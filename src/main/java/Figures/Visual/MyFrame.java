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
        super();
        this.x = x;

        setTitle("Вывод Фигуры");
        setAxis();
        setButton1();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(null);
        setVisible(true);

    }
    public void setAxis(){
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        this.axis = new Axis ();
        this.axis.setBackground(Color.WHITE);
        this.axis.setBounds(100, 0, 700, 700);
        mainContainer.add(axis, BorderLayout.CENTER);

    }
    public void setButton1 (){
        this.button = new JButton("Создать");
        button.setBackground(Color.pink);
        button.setBounds(0, 0, 100, 100);
        add(button);
        button.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        MyGraphs graphs = new MyGraphs (this.x);
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        this.add(graphs);
        this.setVisible(true);
        graphs.setBounds(100, 0, 700, 700);
        mainContainer.add(graphs, BorderLayout.CENTER);
//        MyGraphs allG = new MyGraphs(this.x);
//        Container mainContainer = this.getContentPane();
//        mainContainer.setLayout(new BorderLayout());
//        MyGraphs myG = new MyGraphs(this.x);
//        myG.setBackground(Color.WHITE);
//        mainContainer.add(myG);


    }
}
