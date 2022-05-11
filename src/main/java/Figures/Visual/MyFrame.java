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
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private Axis axis;
    private ArrayList<Figure> x = new ArrayList<>();
    private Container grafCont;
    private JLabel statusLabel;
    private JMenuBar menuBar;
    private JMenu listF;

    private JTextField colorTextField;
    private JTextField nameTextField;
    private Point newP;
    private ArrayList<Point> newArr = new ArrayList<>();
    private JTextField texty;
    private Creator newFabric = new Creator();
    private JTextField textx;
    private JTextField textym;
    private JTextField textxm;
    private JTextField angle;
    private JTextField zoom;
    public static Figure tempF;

    public MyFrame() {
        super();
        setTitle("Вывод Фигуры");
        setMenu();
        setLabelFPoint();
        setAxis();
        setButton1();
        setButton2();
        setButton3();
        setButton4();
        setButton5();
        setButton6();
        setButton7();
        setButton8();
        setAngleBox();
        setZoomBox();
        setMoveBox();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLayout(null);
        setVisible(true);

    }

    public void setMenu() {
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        listF = new JMenu("Список фигур");
        menuBar.add(listF);
    }

    public void setLabelFPoint() {
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
        mainContainer.add(statusLabel);
        mainContainer.add(x);
        mainContainer.add(textx);
        mainContainer.add(y);
        mainContainer.add(texty);
    }

    public void setAxis() {
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        this.axis = new Axis();
        this.axis.setBackground(Color.WHITE);
        this.axis.setBounds(500, 0, 700, 700);
        mainContainer.add(axis, BorderLayout.CENTER);

    }

    public void setButton1() {
        this.button1 = new JButton("Добавить");
        button1.setBackground(Color.pink);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 12);
        button1.setFont(BigFontTR);
        button1.setBounds(5, 135, 200, 20);
        add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int corX = Integer.parseInt(textx.getText());
                int corY = Integer.parseInt(texty.getText());
                newArr.add(new Point(corX, corY));
                textx.setText("");
                texty.setText("");
            }
        });
    }

    public void setButton2() {
        this.button2 = new JButton("Сохранить фигуру");
        button2.setBackground(Color.red);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 10);
        button2.setFont(BigFontTR);
        button2.setBounds(5, 185, 200, 20);
        add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Point> newArr2 = new ArrayList<>();
                for (int i = 0; i < newArr.size(); i++)
                    newArr2.add(newArr.get(i));
                Figure newF = newFabric.create(newArr2);
                x.add(newF);
                JMenuItem newStr = new JMenuItem(newF.toString());
                listF.add(newStr);

                newStr.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MyFrame.setTempF(newF);
                        printOne(MyFrame.tempF);


                    }
                });
                newArr.clear();

            }
        });
    }

    public void setButton3() {

        this.button3 = new JButton("Создать все");
        button3.setBackground(Color.blue);
        button3.setForeground(Color.YELLOW);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 12);
        button3.setFont(BigFontTR);
        button3.setBounds(5, 235, 200, 20);
        add(button3);
        button3.addActionListener(this);
    }

    public void setButton4() {

        this.button4 = new JButton("Очистить список точек");
        button4.setBackground(Color.WHITE);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 10);
        button4.setFont(BigFontTR);
        button4.setBounds(225, 135, 200, 22);
        ;
        add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newArr.clear();
            }
        });
    }

    public void setButton5() {

        this.button5 = new JButton("Очистить список фигур");
        button5.setBackground(Color.BLACK);
        button5.setForeground(Color.WHITE);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 10);
        button5.setFont(BigFontTR);

        button5.setBounds(225, 182, 200, 22);
        ;
        add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.clear();

                System.out.println(listF.getMenuComponentCount());
                for (int i = listF.getMenuComponentCount() - 1; i >= 0; i--) {
                    listF.remove(i);

                }
            }
        });
    }

    public void setButton6() {

        this.button6 = new JButton("Крутить");
        button6.setBackground(Color.WHITE);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 10);
        button6.setFont(BigFontTR);
        button6.setBounds(5, 330, 150, 20);
        ;
        add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double ang = Double.parseDouble(angle.getText());
                MyFrame.tempF.rotate(ang);
                printOne(MyFrame.tempF);
            }
        });
    }

    public void setButton7() {

        this.button7 = new JButton("Массштаб:");
        button7.setBackground(Color.YELLOW);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 10);
        button7.setFont(BigFontTR);
        button7.setBounds(5, 360, 150, 20);
        ;
        add(button7);

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double factor = Double.parseDouble(zoom.getText());
                MyFrame.tempF.multi(factor);
                printOne(MyFrame.tempF);
            }
        });
    }

    public void setButton8() {

        this.button8 = new JButton("Сместить");
        button8.setBackground(Color.GREEN);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 10);
        button8.setFont(BigFontTR);
        button8.setBounds(5, 513, 150, 20);
        ;
        add(button8);

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(textxm.getText());
                double y = Double.parseDouble(textym.getText());
                MyFrame.tempF.move(x, y);
                printOne(MyFrame.tempF);
            }
        });
    }

    public void setAngleBox() {
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        JLabel angleLabel = new JLabel("Ротация");
        JLabel x = new JLabel("Угол в градусах:");
        angle = new JTextField(10);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 20);
        angleLabel.setFont(BigFontTR);

        angleLabel.setBounds(5, 265, 200, 30);
        x.setBounds(5, 295, 150, 20);
        x.setFont(new Font("TimesRoman", Font.BOLD, 15));
        angle.setBounds(150, 295, 200, 20);

        mainContainer.add(angleLabel);
        mainContainer.add(x);
        mainContainer.add(angle);

    }

    public void setZoomBox() {
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        zoom = new JTextField(10);
        zoom.setBounds(200, 360, 150, 20);
        mainContainer.add(zoom);

    }

    public void setMoveBox() {
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        this.statusLabel = new JLabel("Смещение по осям");
        JLabel x = new JLabel("Ось Х:");
        textxm = new JTextField(10);
        JLabel y = new JLabel("Ось Y:");
        textym = new JTextField(10);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 20);
        statusLabel.setFont(BigFontTR);

        statusLabel.setBounds(5, 390, 200, 20);
        x.setBounds(5, 425, 80, 20);
        textxm.setBounds(5, 443, 80, 20);
        y.setBounds(5, 465, 80, 20);
        textym.setBounds(5, 487, 80, 20);
        mainContainer.add(statusLabel);
        mainContainer.add(x);
        mainContainer.add(textxm);
        mainContainer.add(y);
        mainContainer.add(textym);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(newArr);
        MyGraphs graphs = new MyGraphs(this.x);
        grafCont = this.getContentPane();
        grafCont.setLayout(new BorderLayout());
        this.add(graphs);
        graphs.setBounds(500, 0, 700, 700);
        grafCont.add(graphs, BorderLayout.CENTER);

    }

    public void printOne(Figure myFig) {

        MyGraphs graphs = new MyGraphs(myFig);
        grafCont = this.getContentPane();
        grafCont.setLayout(new BorderLayout());
        this.add(graphs);
        graphs.setBounds(500, 0, 700, 700);
        grafCont.add(graphs, BorderLayout.CENTER);
    }

    public static void setTempF(Figure tempF) {
        MyFrame.tempF = tempF;
    }

}
