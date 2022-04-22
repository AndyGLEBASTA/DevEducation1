package Figures;

import Figures.Creators.Creator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        Creator fabric = new Creator();

        Point p1 = new Point (1, 1);
        Point p2 = new Point (1, 3);
        Point p3 = new Point (5, 1);
        Point p4 = new Point (5, 3);
        Point p5 = new Point (9, 12);

        ArrayList <Point> nPoint1 = new ArrayList(Arrays.asList(p4, p3, p1, p2));
        ArrayList <Point> nPoint2 = new ArrayList(Arrays.asList(p1, p2));
        Figure newF = fabric.create(nPoint1);
        System.out.println(newF);
        newF.move(3, 2.5);
        System.out.println(newF);
        newF.rotate(115);
        if (newF.nPoint.size() > 2) System.out.println(newF);
        newF.multi(0.5);

        newF.OutPut();
        newF.InPut();
        System.out.println("Запарсили из result.txt:");
        Figure FromFile = fabric.createFromFile();
        System.out.println(FromFile);
    }
}
