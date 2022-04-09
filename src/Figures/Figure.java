package Figures;

import java.util.ArrayList;

public abstract class Figure {
    protected ArrayList<Point> nPoint;
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

        return String.format("Мы создали %d-угольник с точками:\n" +
                "%sС периметром: %.2f\n" + "С площадью: %.2f\n",
                nPoint.size(), Points, getPerimetr(), getArea());
    }

    /*public abstract void getSquare();*/
    protected double getPerimetr() {
        double res = 0;
        for (int i = 0; i < this.nPoint.size() - 1; i++)
            res += getLineSize(nPoint.get(i), this.nPoint.get(i + 1));
        res += getLineSize(this.nPoint.get(0), this.nPoint.get(this.nPoint.size() - 1));
        return res;
    }
    protected double getLineSize(Point one, Point two) {
        return Math.sqrt((Math.pow((two.getX() - one.getX()), 2) + Math.pow((two.getY() - one.getY()), 2)));
    }
    public Figure(ArrayList <Point> nPoint){
        this.nPoint = pointNear(nPoint);
        System.out.println(this.toString()) ;
    }
    public ArrayList<Point> pointNear(ArrayList<Point> nPoint) {
        ArrayList<Point> newPoint = nPoint;

        for (int i = 0; i < newPoint.size() - 1; i++) {
            double short1 = getLineSize(newPoint.get(i), newPoint.get(i + 1));
            Point temp = newPoint.get(i);
            int tempInd = i;
            for (int j = 1; j < newPoint.size() - 1; j++) {
                double nearLine = getLineSize(newPoint.get(i), newPoint.get(j));
                if (nearLine <= short1) {
                    short1 = nearLine;
                    temp = newPoint.get(j);
                    tempInd = j;
                }
                if (j == newPoint.size() - 2) {
                    newPoint.remove(tempInd);
                    newPoint.add(i + 1, temp);
                }
            }
        }
        return newPoint;
    }
    protected double getArea(){
        double area = 0;
        for(int i = 0; i < nPoint.size(); i++){
            int temp = i + 1 < nPoint.size()? i + 1: 0;
area += nPoint.get(i).getX() * nPoint.get(temp).getY() - nPoint.get(i).getY() * nPoint.get(temp).getX();
        }
        return Math.abs(area/2);
    }
}
