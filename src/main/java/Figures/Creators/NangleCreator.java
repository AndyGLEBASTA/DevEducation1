package Figures.Creators;


import Figures.Figure;
import Figures.Nangle;
import Figures.Point;

import java.util.ArrayList;

public class NangleCreator implements iFigureCreator {


    @Override
    public Figure create(ArrayList< Point > points) {
        return new Nangle(points);
    }
}

