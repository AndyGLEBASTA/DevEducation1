package Figures.Visual;

import Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyGraphs extends JPanel {
    private ArrayList <Figure> myFigs;
    public MyGraphs(ArrayList <Figure> myFigs){
        super();
        this.myFigs = myFigs;
    }
    public void paint (Graphics g) {
        for (var fig : myFigs) {
            for (int i = 0; i < fig.getPoints().size() - 1; i++) {
                g.drawLine((int) fig.getPoints().get(i).getX(), (int) fig.getPoints().get(i).getY(),
                        (int) fig.getPoints().get(i + 1).getX(), (int) fig.getPoints().get(i + 1).getY());
            }
            g.drawLine((int) fig.getPoints().get(fig.getPoints().size() - 1).getX(), (int) fig.getPoints().get(fig.getPoints().size() - 1).getY(),
                    (int) fig.getPoints().get(0).getX(), (int) fig.getPoints().get(0).getY());
        }
    }
}
