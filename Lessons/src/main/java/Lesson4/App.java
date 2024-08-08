package Lesson4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    public App(){
        setTitle("My Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,400,400);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(20,40,300,75);
        add(textArea);

        JButton button = new JButton("Кнопочка");
        button.setBounds(120,20,100,20);
        setLayout(null);
        add(button);
        StringBuilder sb = new StringBuilder();

        button.addActionListener(e -> {
            sb.append("Text\n");
            textArea.setText(sb.toString());
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        new App();

    }
}
