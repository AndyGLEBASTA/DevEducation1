package Figures;

public class Point {
    protected double x;
    protected double y;

    public Point(Point point) {
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public Point (double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Точка (%.2f; %.2f)", x, y);
    }
    public String toStringFile(){
        return String.format("(%.2f; %.2f) ", x, y);
    }
}
