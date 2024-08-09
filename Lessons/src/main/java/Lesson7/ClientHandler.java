package Lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Класс обслуживания клиента (отвечает за связь между клиентом и сервером)
 */
public class ClientHandler {

    private MyServer server;
    private Socket socket;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;

    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.inputStream = new DataInputStream(socket.getInputStream());
            this.outputStream = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            new Thread(() -> {
                try {
                    authentication();
                    readMessages();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException ex) {
            System.out.println("Проблема при создании клиента");
        }
    }

    private void authentication() throws IOException {
        while (true) {
            String message = inputStream.readUTF();
            if (message.startsWith(ChatConst.AUTH_COMMAND)) {
                String[] parts = message.split("\\s+");
                String nick = server.getAuthService().getNickByLoginAdPass(parts[1], parts[2]);
                if (nick != null) {
                    //Проверим, что такого нет!
                    if (!server.isNickBusy(nick)) {
                        sendMsg(ChatConst.AUTH_OK +" "+ nick);
                        name = nick;
                        server.subscribe(this);
                        server.broadcastMessage(name + " вошёл в чат");

                        return;
                    } else {
                        sendMsg("Ник уже используется");
                    }

                } else {
                    sendMsg("Неверный логин/пароль");
                }

            }
        }
    }

    public void sendMsg(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readMessages() throws IOException {
        while (true) {
            String messageFromClient = inputStream.readUTF();
            System.out.println("от " + name + ": " + messageFromClient);
            if (messageFromClient.equals(ChatConst.STOP_WORD)) {
                return;
            }
            server.broadcastMessage("[" + name + "]: " + messageFromClient);
//            server.privateMessage("[" + name + "]: " + messageFromClient);
        }
    }

    public void closeConnection() {
        server.unSubscribe(this);
        server.broadcastMessage(name + " вышел с чата");
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

