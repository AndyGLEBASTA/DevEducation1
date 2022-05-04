package Figures.Visual;


import Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener {
    private JButton button;
    private Axis axis;
    private ArrayList<Figure> x;
    private Container grafCont;


    public MyFrame(ArrayList<Figure> x) {
        super();
        this.x = x;

        setTitle("Вывод Фигуры");
        setAxis();
        setButton1();
        setButton2();
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
    public void setButton2 (){
        this.button = new JButton("Очистить");
        button.setBackground(Color.pink);
        button.setBounds(0, 101, 100, 100);
        add(button);
        button.addActionListener(this::actionPerformed2);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        MyGraphs graphs = new MyGraphs (this.x);
        grafCont = this.getContentPane();
        grafCont.setLayout(new BorderLayout());
        this.add(graphs);
        graphs.setBounds(100, 0, 700, 700);
        grafCont.add(graphs, BorderLayout.CENTER);


    }
    public void actionPerformed2 (ActionEvent e) {
        this.removeAll();
        this.repaint();

        setAxis();


    }

}
