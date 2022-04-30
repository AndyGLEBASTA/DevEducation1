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
        setTitle("Вывод Фигуры");
        setButton1();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);

        setLayout(null);
        setVisible(true);
    }

    public void setAxis(){
        Container mainContainer = this.getContentPane();
        this.axis = new Axis ();
        this.axis.setBackground(Color.WHITE);
        this.axis.setBounds(300, 50, 600, 600);
        mainContainer.add(axis);
    }

    public void setButton1 (){
        this.button = new JButton("Создать фигуры");
        button.setBackground(Color.pink);
        button.setBounds(50, 50, 200, 100);
        add(button);
        button.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MyGraphs graphs = new MyGraphs (this.x);
        graphs.setVisible(true);
        this.add(graphs);



//        MyGraphs allG = new MyGraphs(this.x);
//        Container mainContainer = this.getContentPane();
//        mainContainer.setLayout(new BorderLayout());
//        MyGraphs myG = new MyGraphs(this.x);
//        myG.setBackground(Color.WHITE);
//        mainContainer.add(myG);


    }
}
