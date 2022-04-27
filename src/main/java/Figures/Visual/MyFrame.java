package Figures.Visual;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Figures.Figure;

public class MyFrame extends JFrame implements ActionListener {
    private JButton button;
    private Axis axis;
    private ArrayList<Figure> x;


    public MyFrame(ArrayList<Figure> x) {
        this.x = x;
        Box panel = Box.createVerticalBox();
        setTitle("Вывод Фигуры");
        this.button = new JButton("Создать фигуры");
        button.setBackground(Color.pink);
        button.setBounds(50, 50, 200, 100);
        add(button);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        setLayout(null);
        setVisible(true);
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        axis = new Axis ();
        axis.setBackground(Color.WHITE);
        axis.setBounds(400, 100, 600, 600);
        mainContainer.add(axis);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        MyGraphs graphs = new MyGraphs (this.x);

        this.add(graphs);
        this.setVisible(true);
//        MyGraphs allG = new MyGraphs(this.x);
//        Container mainContainer = this.getContentPane();
//        mainContainer.setLayout(new BorderLayout());
//        MyGraphs myG = new MyGraphs(this.x);
//        myG.setBackground(Color.WHITE);
//        mainContainer.add(myG);


    }
}
