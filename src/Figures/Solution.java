package Figures;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        Point p1 = new Point (0, 0);
        Point p2 = new Point (0, 4);
        Point p3 = new Point (4, 0);
        Point p4 = new Point (4, 4);
        Point p5 = new Point (9, 12);

        ArrayList <Point> nPoint = new ArrayList(Arrays.asList(p1, p2, p3));


        Nangle Triangle = new Nangle(nPoint);


    }
}
