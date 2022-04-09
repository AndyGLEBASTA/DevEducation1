package Figures;

import java.util.ArrayList;

public class Nangle extends Figure {

    public Nangle(ArrayList<Point> nPoint) {
        super(nPoint);
    }


    public double findA(Point one, Point two) {
        return (double) (two.getY() - one.getY()) / (two.getX() - one.getX());

    }

    public double findB(Point one, Point two) {
        return one.getY() - findA(one, two) * one.getX();
    }

    /*public void getSquare(){
        System.out.println("начало площади");
        int countP = 0;
        for (int i = 0; i < this.nPoint.size() - 1; i++){
            System.out.println("вход в главный цикл");
            double a = findA (this.nPoint.get(i), this.nPoint.get(i + 1));
            double b = findB (this.nPoint.get(i), this.nPoint.get(i + 1));
            if (this.nPoint.get(i).getX() < 0 && this.nPoint.get(i + 1).getX() < this.nPoint.get(i).getX()){
                double ceilMinone = Math.floor(this.nPoint.get(i).getX());
                double ceilMintwo = Math.ceil(this.nPoint.get(i + 1).getX());
                for (double j = ceilMinone; j >= ceilMintwo; j--){
                    System.out.println("вход в цикл 1");
                    if ((a * j + b) % 1 == 0 )
                    countP++;
                }
            }
            if (this.nPoint.get(i+1).getX() < 0 && this.nPoint.get(i + 1).getX() > this.nPoint.get(i).getX()){
                double ceilMinone = Math.floor(this.nPoint.get(i + 1).getX());
                double ceilMintwo = Math.ceil(this.nPoint.get(i).getX());
                for (double j = ceilMinone; j >= ceilMintwo; j--){
                    System.out.println("вход в цикл 2");
                    if ((a * j + b) % 1 == 0 )
                    countP++;
                }
            }
            if (this.nPoint.get(i).getX() >= 0 && this.nPoint.get(i + 1).getX() > this.nPoint.get(i).getX()){
                double ceilplusone = Math.ceil(this.nPoint.get(i).getX());
                double ceilplustwo = Math.floor(this.nPoint.get(i + 1).getX());
                for (double j = ceilplusone; j <= ceilplustwo; j++){
                    System.out.println("вход в цикл 3");
                    if ((a * j + b) % 1 == 0 )
                    countP++;
                }
            }
            if (this.nPoint.get(i).getX() >= 0 && this.nPoint.get(i + 1).getX() < this.nPoint.get(i).getX()){
                double ceilplusone = Math.ceil(this.nPoint.get(i + 1).getX());
                double ceilplustwo = Math.floor(this.nPoint.get(i).getX());

                for (double j = ceilplusone; j <= ceilplustwo; j++){
                    System.out.println("вход в цикл 4");
                    if ((a * j + b) % 1 == 0 )
                    countP++;
                }
            }
            if (this.nPoint.get(i).getX() == this.nPoint.get(i + 1).getX() && this.nPoint.get(i).getX() % 1 == 0){

                   if ( this.nPoint.get(i).getY() < 0 && this.nPoint.get(i + 1).getY() < this.nPoint.get(i).getY()){
                       double ceilMinone = Math.floor(this.nPoint.get(i).getY());
                       double ceilMintwo = Math.ceil(this.nPoint.get(i + 1).getY());
                       for (double j = ceilMinone; j >= ceilMintwo; j--){
                           System.out.println("вход в цикл 11");
                               countP++;
                       }
                   }
                if ( this.nPoint.get(i+1).getY() < 0 && this.nPoint.get(i + 1).getY() > this.nPoint.get(i).getY()){
                    double ceilMinone = Math.floor(this.nPoint.get(i+1).getY());
                    double ceilMintwo = Math.ceil(this.nPoint.get(i ).getY());
                    for (double j = ceilMinone; j >= ceilMintwo; j--){
                        System.out.println("вход в цикл 22");
                        countP++;
                    }
                }
                if ( this.nPoint.get(i).getY() >= 0 && this.nPoint.get(i + 1).getY() < this.nPoint.get(i).getY()){
                    double ceilMinone = Math.ceil(this.nPoint.get(i + 1).getY());
                    double ceilMintwo = Math.floor(this.nPoint.get(i).getY());
                    for (double j = ceilMinone; j <= ceilMintwo; j++){
                        System.out.println("вход в цикл 33");
                        countP++;
                    }
                }
                if ( this.nPoint.get(i).getY() >= 0 && this.nPoint.get(i + 1).getY() > this.nPoint.get(i).getY()){
                    double ceilMinone = Math.ceil(this.nPoint.get(i).getY());
                    double ceilMintwo = Math.floor(this.nPoint.get(i+1).getY());
                    for (double j = ceilMinone; j <= ceilMintwo; j++){
                        System.out.println("вход в цикл 44");
                        countP++;
                    }
                }


            }
            if(i == this.nPoint.size() - 1){
                a = findA (this.nPoint.get(0), this.nPoint.get(this.nPoint.size() - 1));
                b = findB (this.nPoint.get(0), this.nPoint.get(this.nPoint.size() - 1));

            }

        }
System.out.printf("Площадь по формуле Пика равна: %d\n", (countP ));

    }*/
    public int findAllPoints(Point one, Point two) {
        double a = findA(one, two);
        double b = findB(one, two);
        int countP = 0;
        double ceilone, ceiltwo;
        if (one.getX() < 0 && two.getX() < one.getX()) {
            ceilone = Math.floor(one.getX());
            ceiltwo = Math.ceil(two.getX());
            for (double j = ceilone; j >= ceiltwo; j--) {
                System.out.println("вход в цикл 1");
                if ((a * j + b) % 1 == 0)
                    countP++;
            }
        }
        if (two.getX() < 0 && two.getX() > one.getX()) {
            ceilone = Math.floor(two.getX());
            ceiltwo = Math.ceil(one.getX());
            for (double j = ceilone; j >= ceiltwo; j--) {
                System.out.println("вход в цикл 2");
                if ((a * j + b) % 1 == 0)
                    countP++;
            }
        }
        if (one.getX() >= 0 && two.getX() > one.getX()) {
            ceilone = Math.ceil(one.getX());
            ceiltwo = Math.floor(two.getX());
            for (double j = ceilone; j <= ceiltwo; j++) {
                System.out.println("вход в цикл 3");
                if ((a * j + b) % 1 == 0)
                    countP++;
            }
        }
        if (one.getX() >= 0 && two.getX() < one.getX()) {
            ceilone = Math.ceil(two.getX());
            ceiltwo = Math.floor(one.getX());

            for (double j = ceilone; j <= ceiltwo; j++) {
                System.out.println("вход в цикл 4");
                if ((a * j + b) % 1 == 0)
                    countP++;
            }
        }
        if (one.getX() == two.getX() && one.getX() % 1 == 0) {

            if (one.getY() < 0 && two.getY() < one.getY()) {
                ceilone = Math.floor(one.getY());
                ceiltwo = Math.ceil(two.getY());
                for (double j = ceilone; j >= ceiltwo; j--) {
                    System.out.println("вход в цикл 11");
                    countP++;
                }
            }
            if (two.getY() < 0 && two.getY() > one.getY()) {
                ceilone = Math.floor(two.getY());
                ceiltwo = Math.ceil(one.getY());
                for (double j = ceilone; j >= ceiltwo; j--) {
                    System.out.println("вход в цикл 22");
                    countP++;
                }
            }
            if (one.getY() >= 0 && two.getY() < one.getY()) {
                ceilone = Math.ceil(two.getY());
                ceiltwo = Math.floor(one.getY());
                for (double j = ceilone; j <= ceiltwo; j++) {
                    System.out.println("вход в цикл 33");
                    countP++;
                }
            }
            if (one.getY() >= 0 && two.getY() > one.getY()) {
                ceilone = Math.ceil(one.getY());
                ceiltwo = Math.floor(two.getY());
                for (double j = ceilone; j <= ceiltwo; j++) {
                    System.out.println("вход в цикл 44");
                    countP++;
                }
            }


        }
        return countP;
    }

}
