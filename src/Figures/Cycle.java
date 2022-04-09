package Figures;

import java.util.ArrayList;


public class Cycle extends Figure {
double radius;
    public Cycle(ArrayList<Point> nPoint) {
        super(nPoint);
        this.radius
    }
    public double getRadius(){
        Point one = nPoint.get(0);
        Point two = nPoint.get(1);

        double Math.sqrt((Math.pow((two.getX() - one.getX()), 2) + Math.pow((two.getY() - one.getY()), 2)))
    }



}
