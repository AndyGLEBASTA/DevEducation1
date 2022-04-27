package Variables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите номер задачи (1, 2, 3, 4 или 5):");
        String ex = strInput();
        while(!ex.equals("exit")) {

            switch (ex) {
                case "1" -> Ex1();
                case "2" -> Ex2();
                case "3" -> Ex3();
                case "4" -> Ex4();
                case "5" -> Ex5();
                default -> {
                }
            }
            ex = strInput();

        }
    }
    public static void Ex1() throws IOException{
        System.out.println("1) *Пользователь вводит 2 числа (A и B). " +
                "Выведите в консоль результат деления A на B и остаток от деления.");

        System.out.printf("число А: %d%nЧисло В: %d%n", numInput(), numInput());
    }
    public static void Ex2 () throws IOException {
        System.out.println("2) Пользователь вводит 2 числа (A и B). Выведите в консоль решение 5*A+B2B-A");
        int A = numInput();
        int B = numInput();
        int sol = 5 * A + B * 2 * B - A;
        System.out.printf("число А: %d%nЧисло В: %d%n5*A+B2B-A = %d%n", A, B, sol );
    }
    public static void Ex3 () throws IOException{
        System.out.println("3) *Пользователь вводит 2 строковых(string) значения(A и B). " +
                "Поменяйте содержимое переменных A и B местами.");
        String strA = strInput();
        String strB = strInput();
        System.out.printf("Значение А: %s%nЗначение В: %s%n", strA, strB);
        String strC = strA;
        strA = strB;
        strB = strC;
        System.out.printf("Значение А после замены: %s%nЗначение В после замены: %s%n", strA, strB);
    }

    public static void Ex4 () throws IOException {
        System.out.println("Пользователь вводит 3 не равных 0 числа (A, B и С). " +
                "Выведите в консоль решение(значение X) линейного уравнения стандартного вида, где A*X+B=C.");
        int A = numInput();
        int B = numInput();
        int C = numInput();
        double X = (double) (C - B) / A;
        System.out.printf("число А: %d%nЧисло В: %d%nЧисло C: %d%nПри A*X+B=C, X = %.2f%n", A, B, C, X );
    }
    public static void Ex5 () throws IOException{
        System.out.println("Пользователь вводит 4 числа (X1, Y1, X2, Y2), описывающие координаты 2-х " +
                "точек на координатной плоскости. Выведите уравнение прямой в формате Y=AX+B, " +
                "проходящей через эти точки.");

        int X1 = numInput();
        int Y1 = numInput();
        int X2 = numInput();
        int Y2 = numInput();
        System.out.printf("Координаты точек: (%d, %d); (%d, %d)%n", X1, Y1, X2, Y2);
        System.out.println(findFunc(X1, Y1, X2, Y2));
    }
    public static String findFunc (int X1, int Y1, int X2, int Y2) {
        String func;
        if (((double)(Y2 - Y1) / (X2 - X1)) % 1 != 0) {
            double A = (double) (Y2 - Y1) / (X2 - X1);
            double B = Y1 - A * X1;
            func = String.format("Формула функции по координатам: Y = %.2f * X + %.2f", A, B);
        }
        else{
            int A = (Y2 - Y1) / (X2 - X1);
            int B = Y1 - A * X1;
            func = String.format("Формула функции по координатам: Y = %d * X + %d", A, B);
        }
        return func;
    }


    public static int numInput () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }
    public static String strInput () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

}
