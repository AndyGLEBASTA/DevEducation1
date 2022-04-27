package Figures.Visual;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{
    JButton button;

    public MyFrame (String title){
        setTitle("Вывод Фигуры");
        this.button = new JButton("Создать фигуру");
        button.setBackground(Color.pink);
        button.setBounds(100, 100, 300, 300);
        add(button);
        button.addActionListener(new ListenerAction());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);
        setVisible(true);

    }



}
