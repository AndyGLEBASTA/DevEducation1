package Figures.Creators;

import java.io.*;
import java.util.ArrayList;

import Figures.Figure;
import Figures.Point;

public class Creator implements iFigureCreator {

       @Override
    public Figure create(ArrayList<Point> points) {
        iFigureCreator creator;
        int numPoints = points.size();

        if (numPoints == 2) creator = new CycleCreator();
        else if (numPoints == 3) creator = new TriangleCreator();
        else if (numPoints == 4) creator = new RectangleCreator();
        else if (numPoints > 4) creator = new NangleCreator();

        else return null;
        return creator.create(points);
    }
    public Figure createFromFile() throws IOException {

        ArrayList<Point> nPoint = new ArrayList<>();
        FileInputStream stream = new FileInputStream("c:/result.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(stream.readAllBytes());
        String temp = baos.toString();
        temp = temp.trim().replaceAll(",", ".");
        while(temp.contains(".")) {
            int index = temp.indexOf(".");
            int index2 = temp.indexOf("(");
            double x = Double.parseDouble(temp.substring(index2 + 1, index + 3));
            temp = temp.substring(index+1);
            index = temp.indexOf(".");
            index2 = temp.indexOf(" ");
            double y = Double.parseDouble(temp.substring(index2 + 1, index + 3));
            var point = new Point (x, y);
            temp = temp.substring(index + 1);
            nPoint.add(point);
        }
        stream.close();
        return this.create(nPoint);
    }

}
