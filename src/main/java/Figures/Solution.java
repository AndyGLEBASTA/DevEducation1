package Figures;

import Figures.Creators.Creator;
import Figures.Visual.MyFrame;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import Figures.Visual.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        Creator fabric = new Creator();
        ObjectMapper mapper = new ObjectMapper();

        Point p1 = new Point (500, 500);
        Point p2 = new Point (500, 0);
        Point p3 = new Point (0, 500);
        Point p4 = new Point (0, 0);
        Point p5 = new Point (9, 12);

        ArrayList <Point> nPoint1 = new ArrayList(Arrays.asList(p4, p3, p1, p2));
        ArrayList <Point> nPoint2 = new ArrayList(Arrays.asList(p1, p2));
        ArrayList <Figure> allF = new ArrayList<>();
        Figure newF = fabric.create(nPoint1);
        Figure newF2 = fabric.create(nPoint2);
        System.out.println(newF);
        newF.move(3, 2.5);
        System.out.println(newF);
        newF.rotate(0);
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
        allSerial2(allF);
        allDeSerial2();

        MyFrame f = new MyFrame (allF);



    }
    public static void Serial (Figure f){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/Figure.dat")))
        {
            oos.writeObject(f);
            System.out.println("Внимание! Сохранение фигуры в файл .dat завершено!!");
        }
        catch(Exception ex){
            System.out.println("Ошибка сериализации фигуры!");
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

            System.out.println("Ошибка десериализаци фигуры из файла!!");
        }
    }
    public static void allSerial (ArrayList <Figure> allF){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/Figures.dat")))
        {

            oos.writeObject(allF);
            System.out.println("Внимание! Сохранение списка объектов фигур в файл .dat завершено!!");
        }
        catch(Exception ex){
            System.out.println("Ошибка сериализации списка фигур!!");
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

            System.out.println("Ошибка десериализации спика фигур из файла!!");
        }
    }
    public static void allSerial2 (ArrayList <Figure> allF){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/Figures.dat")))
        {
            for(Figure f : allF)
            oos.writeObject(f);
            System.out.println("Внимание! Сохранение списка объектов фигур в файл .dat завершено 2!!");
        }
        catch(Exception ex){
            System.out.println("Ошибка сериализации списка фигур 2!!");
        }
    }
    public static void allDeSerial2 ()  {
        ArrayList<Figure> allF = new ArrayList<>();
        FileInputStream file = null;
        try {
            file = new FileInputStream("c:/Figures.dat");}
        catch (FileNotFoundException e) {
            System.out.println("Ошибка поиска файла!");
        }
            ObjectInputStream ois = null;
            try{
                ois = new ObjectInputStream(file);}
            catch (IOException e) {
                System.out.println("Ошибка конвертации файла!");
            }
                int i = -1;
            try {
                while (file.available() != 0) {
                    Figure ff = (Figure) ois.readObject();
                    allF.add(ff);
                }
                System.out.println("Считывание списка объектов фигур из файла .dat 2:");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ошибка десериализации списка фигур из файла 2!!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Ошибка десериализации списка фигур из файла 2!!");
            }
            for (Figure x : allF)
        System.out.println(x);
        }

}
