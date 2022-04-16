package Figures;

import Figures.Creators.Creator;

import java.util.ArrayList;
import Figures.Creators.Creator;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Creator a = new Creator();

        Point p1 = new Point (0, 0);
        Point p2 = new Point (0, 1);
        Point p3 = new Point (4, 0);
        Point p4 = new Point (4, 4);
        Point p5 = new Point (9, 12);

        ArrayList <Point> nPoint1 = new ArrayList(Arrays.asList(p1, p2, p3));
        ArrayList <Point> nPoint2 = new ArrayList(Arrays.asList(p1, p2));
        a.create(nPoint1);



    }
}
