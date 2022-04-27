package Figures.Visual;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Figures.Figure;

public class MyFrame extends JFrame implements ActionListener{
    JButton button;
    ArrayList<Figure> x;


    public MyFrame (ArrayList<Figure> x){
        this.x = x;
        setTitle("Вывод Фигуры");
        this.button = new JButton("Создать фигуру");
        button.setBackground(Color.pink);
        button.setBounds(100, 100, 300, 300);
        add(button);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MyGraphs allG = new MyGraphs(this.x);
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.add (allG);
        frame.setVisible(true);
    }
}
