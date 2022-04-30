package Figures.Visual;

import Figures.Cycle;
import Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyGraphs extends JPanel {
    private int width;
    private int height;
    private ArrayList <Figure> myFigs;
    public MyGraphs(ArrayList <Figure> myFigs){
        super();
        this.myFigs = myFigs;
    }
    public void paint (Graphics g) {
        super.paint(g);
        this.setBackground(Color.WHITE);
//        this.setBounds(0, 0, 600, 600);
this.setSize(600, 600);
        for (var fig : myFigs) {
//            if (fig.getPoints().size() == 2) {
//                g.drawOval((int) fig.getPoints().get(0).getX(), (int) fig.getPoints().get(0).getY(),
//                        (int) ((Cycle) fig).getRadius(), (int) ((Cycle) fig).getRadius());
//            } else {
                for (int i = 0; i < fig.getPoints().size() - 1; i++) {
                    g.drawLine((int) fig.getPoints().get(i).getX(), (int) fig.getPoints().get(i).getY(),
                            (int) fig.getPoints().get(i + 1).getX(), (int) fig.getPoints().get(i + 1).getY());
                }
                g.drawLine((int) fig.getPoints().get(fig.getPoints().size() - 1).getX(), (int) fig.getPoints().get(fig.getPoints().size() - 1).getY(),
                        (int) fig.getPoints().get(0).getX(), (int) fig.getPoints().get(0).getY());

        }
//        width = getWidth(); // сохраняем текущую ширину панели
//        height = getHeight(); // и высоту
//        drawGrid(g); // рисуем сетку
//        drawAxis(g); // рисуем оси

    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);  //задаем серый цвет

        for(int x=width/2; x<width; x+=10){  // цикл от центра до правого края
            g.drawLine(x, 0, x, height);    // вертикальная линия
        }

        for(int x=width/2; x>0; x-=10){  // цикл от центра до леваого края
            g.drawLine(x, 0, x, height);   // вертикальная линия
        }

        for(int y=height/2; y<height; y+=10){  // цикл от центра до верхнего края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }

        for(int y=height/2; y>0; y-=10){  // цикл от центра до леваого края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }
    }

    private void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(width/2, 0, width/2, height);
        g.drawLine(0, height/2, width, height/2);
    }




}
