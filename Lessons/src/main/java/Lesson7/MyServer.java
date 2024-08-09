package Lesson7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * Непосредственно сервер
 */

public class MyServer {
    private List<ClientHandler> clients;
    private AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public MyServer() {
        try (ServerSocket serverSocket = new ServerSocket(ChatConst.PORT)) {
            authService = new BaseAuthService();
            authService.start();
            clients = new ArrayList<>();
            while(true){
                System.out.println("Сервер ожидает подключения");
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized boolean isNickBusy(String nick) {
        return clients.stream().anyMatch(client -> client.getName().equals(nick));
//        for (ClientHandler client : clients) {
//            if (client.getName().equals(nick)){
//                return true;
//            }
//        }
//        return false;

    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public synchronized void unSubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    /**
     * broadcastMessage Отправляет сообщение всем пользователям
     * @param message
     */
    public synchronized void broadcastMessage(String message) {
        clients.forEach(client -> client.sendMsg(message));
//        for (ClientHandler client : clients) {
//            client.sendMsg(message);
//        }
    }
//    public synchronized void privateMessage(String message) {
//        if
//        clients.forEach(client. -> client.sendMsg(message));
////        for (ClientHandler client : clients) {
////            client.sendMsg(message);
////        }
//    }
}
