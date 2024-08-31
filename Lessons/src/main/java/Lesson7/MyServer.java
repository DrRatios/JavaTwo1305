package Lesson7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
            while (true) {
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
        broadcastClients();
    }

    public synchronized void unSubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastClients();
    }

    /**
     * broadcastMessage Отправляет сообщение всем пользователям
     *
     * @param message
     */
    public synchronized void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMsg(message);
        }
    }

    //    public synchronized void privateMessage(ClientHandler from, String to, String message) {
//        for (ClientHandler client : clients) {
//            if (client.getName().equals(to)) {
//                client.sendMsg("PrivateMessageFrom: " + from.getName() +"-> "+ message);
//            }
//            break;
//        }
//        from.sendMsg("[PrivateMessageTo: " + to + "] " + message);
//    }
    public synchronized void broadcastMessageToClients(String message, List<String> nicknames) {
        clients.stream().filter(c -> nicknames.contains(c.getName()))
                .forEach(c -> c.sendMsg(message));

//        for (ClientHandler client : clients) {
//            if (!nicknames.contains(client.getName())){
//                continue;
//            }
//        client.sendMsg(message)
//        }
    }

    public synchronized void broadcastClients() {
        String clientMessage = ChatConst.CLIENTS_LIST +
                " " +
                clients.stream()
                        .map(ClientHandler::getName)
                        .collect(Collectors.joining(" "));
//      clients.stream().map(c->c.getName()).forEach(n->sb.append(n).append(" "));
        clients.forEach(c->c.sendMsg(clientMessage));
    }

}


//        String[] parts = message.split("\\s+");
//        String pwNick = getAuthService().getNickByLoginAdPass(parts[1], parts[2]);
//        if (message.startsWith(ChatConst.PRIVATE_MESSAGE){
//
//
//        }
//        for (ClientHandler client : clients) {
//            client.sendMsg(message);
//        }

//    public synchronized void privateMessage(String message) {
//        if
//        clients.forEach(client. -> client.sendMsg(message));
////        for (ClientHandler client : clients) {
////            client.sendMsg(message);
////        }
//    }


