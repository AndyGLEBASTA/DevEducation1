package Figures.Creators;

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
}
