package Figures.Visual;

import Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Axis extends JPanel {
    private int width;
    private int height;
    public Axis(){
        super();
    }

    public void paint (Graphics g) {
        super.paint(g);
        width = getWidth(); // сохраняем текущую ширину панели
        height = getHeight(); // и высоту
        drawGrid(g); // рисуем сетку
        drawAxis(g); // рисуем оси
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
