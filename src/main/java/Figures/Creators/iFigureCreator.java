package Figures.Creators;

import Figures.Figure;
import Figures.Point;

import java.util.ArrayList;

public interface iFigureCreator {
 Figure create (ArrayList <Point> points);
}
