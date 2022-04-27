package Figures;

import java.util.ArrayList;

public class Triangle extends Figure{

    public Triangle(ArrayList<Point> nPoint) {
        super(nPoint);
    }
    public String toString(){
        String Points = null;
        for (Point x : this.nPoint){
            if (Points == null) {
                Points = String.valueOf(x) +"\n";
            }
            else {
                Points += String.valueOf(x) + "\n";
            }
        }

        return String.format("Мы создали треугольник с точками:\n" +
                        "%sС периметром: %.2f\n" + "С площадью: %.2f\n",
                 Points, getPerimetr(), getArea());
    }
}
