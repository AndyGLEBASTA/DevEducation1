package Figures;

import Figures.Creators.Creator;

import java.io.*;
import java.util.ArrayList;


public abstract class Figure implements Serializable{
    protected ArrayList<Point> nPoint;
    protected String color;
    public Figure(ArrayList <Point> nPoint) {
        this.nPoint = pointNear(nPoint);
            }
    public String toString(){
        String Points = null;
        for (Point x : this.nPoint){
            if (Points == null) {
                Points = x +"\n";
            }
            else Points += x + "\n";
        }

        return String.format("""
                        Мы создали %d-угольник с точками:
                        %sС периметром: %.2f
                        С площадью: %.2f
                         С цветом:%s""",
                nPoint.size(), Points, getPerimetr(), getArea(), color);
    }
    public Figure thisFig (){
        Creator b = new Creator();
        return b.create(this.nPoint);
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

    public ArrayList<Point> pointNear(ArrayList<Point> nPoint) {
        ArrayList<Point> newPoint = nPoint;

        for (int i = 0; i < newPoint.size() - 1; i++) {
            double short1 = getLineSize(newPoint.get(i), newPoint.get(i + 1));

            Point temp = newPoint.get(i);
            int tempInd = i;
            for (int j = i + 1; j < newPoint.size() ; j++) {
                double nearLine = getLineSize(newPoint.get(i), newPoint.get(j));
                if (nearLine <= short1) {
                    short1 = nearLine;
                    temp = newPoint.get(j);
                    tempInd = j;
                }
                if (j == newPoint.size() - 1) {
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

    public String getColor() {
        return this.color;
    }

    public void setColor (String color){
        this.color = color;
    }

    public void OutPut() throws IOException {
        FileOutputStream stream = new FileOutputStream("c:/result.txt", false);

        var result = new Object(){
            String name = "";
        };
        this.nPoint.forEach(r -> result.name += r.toStringFile());
        String name = getClass().toString().substring(14) + ": " + result.name + "\n";
        byte [] arr = name.getBytes();
            stream.write(arr, 0, arr.length);
            stream.close();
    }
    public void InPut() throws IOException {

        FileInputStream stream = new FileInputStream("c:/result.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    baos.write(stream.readAllBytes());
                    System.out.println(baos);
        stream.close();
    }
    public Point findBarCentre (){     // Определение местоположения барицентра для конечного множества точек
        ArrayList <Point> buffer = this.nPoint;
        double x = 0.0;
        double y = 0.0;
        int k = 0;
        for(Point temp: buffer){
            k++;
            x += temp.getX();
            y += temp.getY();
        }
        return new Point (x / k , y / k);

    }
    public void rotate (double ang){ //поворот фигуры через поворот точек по формуле:
                                     // X'=Xo+(X1-Xo)∗cos(ϕ)−(Y1-Yo)∗sin(ϕ)
                                     // Y'=Yo +(X1-Xo)∗sin(ϕ)+(Y1-Yo)∗cos(ϕ)
        ArrayList <Point> buffer = this.nPoint;

        if (ang > 0 && ang < 360 && buffer.size() > 2){
            Point centre = this.findBarCentre();
            double xC = centre.getX();
            double yC = centre.getY();
                buffer.replaceAll( x -> {double a = x.getX() - xC; double b = x.getY() - yC;
                    x.setX(xC + a * Math.cos(Math.toRadians(ang)) - b * Math.sin(Math.toRadians(ang)));
                    x.setY(yC + a * Math.sin(Math.toRadians(ang)) + b * Math.cos(Math.toRadians(ang)));
                    return x;});
            this.nPoint = buffer;
        }
        else if (buffer.size() == 2) System.out.println("Круг есть круг, что его крутить то!");
        else
            System.out.println("Ошибка ввода градусов!");
    }
    public void multi (double factor){
        ArrayList <Point> buffer = this.nPoint;
        Point centre = this.findBarCentre();
        double xC = centre.getX();
        double yC = centre.getY();
        buffer.replaceAll(x -> {x.setX((x.getX() - xC) * factor + xC);
            x.setY((x.getY() - yC) * factor + yC); return x;});
    }

    public void move (double x, double y){
        ArrayList <Point> buffer = this.nPoint;
        buffer.replaceAll(point -> {point.setX((point.getX() + x));
            point.setY(point.getY() + y); return point;});
        this.nPoint = buffer;
    }

}
