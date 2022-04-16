package Figures;

import java.util.ArrayList;

public class Rectangle extends Figure{

    public Rectangle(ArrayList<Point> nPoint) {
        super(nPoint);
    }
    public String toString(){
        String Points = null;
        for (Point x : this.nPoint){
            if (Points == null) {
                Points = x +"\n";
            }
            else {
                Points += x + "\n";
            }
        }

        return String.format("Мы создали четырёхугольник с точками:\n" +
                        "%sС периметром: %.2f\n" + "С площадью: %.2f\n",
                Points, getPerimetr(), getArea());
    }
}
