package Lesson6HW;


import Lesson_6.EchoConstans;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(EchoConst.PORT)) {
            System.out.println("Server started. Wait for connection...");
            socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            new Thread(() -> {
                try {
                    while (true) {
                        String string = inputStream.readUTF();
                        if (string.equals(EchoConst.STOP_WORD)) {
                            break;
                        }
                        System.out.println("Message received " + string);
                    }
                    System.out.println("Server shutting down");
                    inputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    while (true) {
                        String string1 = bufferedReader.readLine();
                        if (string1.equals(EchoConst.STOP_WORD)) {
                            break;
                        }
                        outputStream.writeUTF(string1);
                    }
                    System.out.println("Server shutting down");
                    inputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }).start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
