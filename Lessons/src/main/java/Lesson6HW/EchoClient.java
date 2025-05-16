package Lesson6HW;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Socket socket;

    public static void main(String[] args) {
        new EchoClient();
    }

    public EchoClient() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sendMessage();
    }

    private synchronized void openConnection() throws IOException {
        socket = new Socket(EchoConst.HOST, EchoConst.PORT);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        new Thread(() -> {
            try {
                while (true) {
                    String strFromServer = inputStream.readUTF();
                    System.out.println("Message from server: " + strFromServer);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

//    private void closeConnection() {
//        try {
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public synchronized void sendMessage() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        new Thread(() -> {
        try {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                outputStream.writeUTF(s);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        }).start();


    }
}

