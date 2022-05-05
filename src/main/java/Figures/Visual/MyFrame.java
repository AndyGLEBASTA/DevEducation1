package Figures.Visual;


import Figures.Creators.Creator;
import Figures.Figure;
import Figures.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private Axis axis;
    private ArrayList<Figure> x = new ArrayList<>();
    private Container grafCont;
    private JLabel statusLabel;
    private JTextField colorTextField;
    private JTextField nameTextField;
    private Point newP;
    private ArrayList <Point> newArr = new ArrayList<>();
    private JTextField texty;
    private Creator newFabric = new Creator();
private JTextField textx;

    public MyFrame() {
        super();
                setTitle("Вывод Фигуры");
        setLabelFPoint();
        setAxis();
      setButton1();
    setButton2();
    setButton3();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(null);
        setVisible(true);

    }
    public void setLabelFPoint (){
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
this.statusLabel = new JLabel("Точка фигуры");
JLabel x = new JLabel("Ось Х:");
textx = new JTextField(10);
        JLabel y = new JLabel("Ось Y:");
        texty = new JTextField(10);

statusLabel.setBounds(5, 10, 90, 20);
x.setBounds(5, 35, 80, 20);
textx.setBounds(5, 60, 80, 20);
        y.setBounds(5, 85, 80, 20);
        texty.setBounds(5, 110, 80, 20);
mainContainer.add (statusLabel);
        mainContainer.add (x);
        mainContainer.add (textx);
        mainContainer.add (y);
        mainContainer.add (texty);
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
        this.button1 = new JButton("Добавить");
        button1.setBackground(Color.pink);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 8);
        button1.setFont(BigFontTR);
        button1.setBounds(5, 135, 80, 20);
        add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int corX = Integer.parseInt(textx.getText());
                int corY = Integer.parseInt(texty.getText());
                newArr.add(new Point(corX, corY));
            }
        });
    }
    public void setButton2 (){
        this.button2 = new JButton("Сохранить");
        button2.setBackground(Color.red);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 8);
        button2.setFont(BigFontTR);
        button2.setBounds(5, 170, 80, 20);
        add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList <Point> newArr2 = newArr;
                x.add (newFabric.create(newArr2));
                

            }
        });
    }
    public void setButton3 (){
        this.button3 = new JButton("Создать");
        button3.setBackground(Color.blue);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 8);
        button3.setFont(BigFontTR);
        button3.setBounds(5, 195, 80, 20);
        add(button3);
        button3.addActionListener(this);
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

}
