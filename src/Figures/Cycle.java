package Figures;

import java.util.ArrayList;


public class Cycle extends Figure {
double radius;
    public Cycle(ArrayList<Point> nPoint) {
        super(nPoint);
        this.radius = getRadius();
    }
    public double getRadius(){
        Point one = nPoint.get(0);
        Point two = nPoint.get(1);

        return Math.sqrt((Math.pow((two.getX() - one.getX()), 2) + Math.pow((two.getY() - one.getY()), 2)));
    }

    @Override
    public String toString() {

     return String.format("Мы создали %s с длиной окружности %.2f и площадью %.2f",
             getClass().toString(), getPerimetr(),getArea());
    }

    @Override
    protected double getArea(){
        return Math.PI * getRadius()* getRadius();
    }

    @Override
    protected double getPerimetr() {
        return Math.PI * 2 * getRadius();
    }

}
