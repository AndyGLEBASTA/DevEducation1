package Figures.Creators;

import Figures.*;


import java.util.ArrayList;

public class CycleCreator implements iFigureCreator{



    @Override
    public Figure create(ArrayList<Point> points) {
        return new Cycle (points);
    }
}
