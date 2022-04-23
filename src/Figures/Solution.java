package Figures;

import Figures.Creators.Creator;

import java.io.*;
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
        ArrayList <Figure> allF = new ArrayList<>();
        Figure newF = fabric.create(nPoint1);
        Figure newF2 = fabric.create(nPoint2);
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
        System.out.println(newF);
        allF.add(newF);
        allF.add(newF2);
        Serial(newF);
        deSerial();
        allSerial(allF);
        allDeSerial();
    }
    public static void Serial (Figure f){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/Figure.dat")))
        {
            oos.writeObject(f);
            System.out.println("Внимание! Сохранение фигуры в файл .dat завершено!!");
        }
        catch(Exception ex){
            System.out.println("Хрень");
        }
    }
    public static void deSerial (){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/Figure.dat")))
        {
            System.out.println("Считывание фигуры из файла .dat:");
            Figure ff=(Figure)ois.readObject();
            System.out.println(ff);
        }
        catch(Exception ex){

            System.out.println("Опять хрень");
        }
    }
    public static void allSerial (ArrayList <Figure> allF){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/Figures.dat")))
        {

            oos.writeObject(allF);
            System.out.println("Внимание! Сохранение списка объектов фигур в файл .dat завершено!!");
        }
        catch(Exception ex){
            System.out.println("Хрень2");
        }
    }
    public static void allDeSerial (){

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/Figures.dat")))
        {
            ArrayList <Figure> allF=(ArrayList<Figure>)ois.readObject();
            System.out.println("Считывание списка объектов фигур из файла .dat:");
            for (Figure x : allF)
            System.out.println(x);
        }
        catch(Exception ex){

            System.out.println("Опять хрень2");
        }
    }
}
