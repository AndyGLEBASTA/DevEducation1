package Branching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println("Структуры ветвления\n" +
                "1) Пользователь вводит 2 числа (A и B). Если A>B, подсчитать A+B, если A=B, " +
                "подсчитать A*B, если A<B, подсчитать A-B.\n" +
                "2) Пользователь вводит 2 числа (X и Y). " +
                "Определить какой четверти принадлежит точка с координатами (X,Y).\n" +
                "3) Пользователь вводит 3 числа (A, B и С). Выведите их в консоль в порядке возрастания.\n" +
                "4) Пользователь вводит 3 числа (A, B и С). " +
                "Выведите в консоль решение(значения X) квадратного уравнения стандартного вида, где AX2+BX+C=0.\n" +
                "5) Пользователь вводит двузначное число. Выведите в консоль прописную запись этого числа. " +
                "Например при вводе “25” в консоль будет выведено “двадцать пять”.\n" +
                "6) Определить, попадает ли точка M(x,y) в круг радиусом r с центром в точке (x0,y0)\n" +
                "7) Написать программу, которая печатает True или False в зависимости от того, " +
                "выполняются или нет заданные условия:\n" +
                "*квадрат заданного трехзначного числа равен кубу суммы цифр этого числа;\n" +
                "*сумма двух первых цифр заданного четырехзначного числа равна сумме двух его последних цифр;\n" +
                "*среди цифр заданного трехзначного числа есть одинаковые;\n" +
                "*среди первых трех цифр из дробной части заданного " +
                "положительного вещественного числа есть цифра 0.\n" +
                "Введите номер задачи (1, 2, 3, 4, 5, 6 или 7):");
        String ex = strInput();
        while(!ex.equals("exit")) {

            switch (ex) {
                case "1" -> Ex1();
                case "2" -> Ex2();
                case "3" -> Ex3();
                case "4" -> Ex4();
                case "5" -> Ex5();
                case "6" -> Ex6();
                case "7" -> Ex7();
                default -> {
                }
            }
            ex = strInput();

        }
    }
    public static void Ex1() throws IOException{
        System.out.println("1) Пользователь вводит 2 числа (A и B). " +
                        "Если A>B, подсчитать A+B, если A=B, подсчитать A*B, если A<B, подсчитать A-B.");
        int A = numInput();
        int B = numInput();
        System.out.printf("число А: %d%nЧисло В: %d%n", A, B);
        if (A > B)
            System.out.println("A + B = " + (A + B));
        if (A == B)
            System.out.println("A * B = " + (A * B));
        if (A < B)
            System.out.println("A - B = " + (A - B));
    }
    public static void Ex2 () throws IOException {
        System.out.println("2) Пользователь вводит 2 числа (X и Y). " +
                "Определить какой четверти принадлежит точка с координатами (X,Y).");
        int X = numInput();
        int Y = numInput();
        int sq;
        sq = (X > 0 && Y > 0)? 1: (X < 0 && Y > 0)? 2:(X < 0 && Y < 0)? 3: (X > 0 && Y < 0)? 4: 0;
        if (sq != 0)
            System.out.printf("Координаты (X,Y): (%d, %d)%n" +
                    "Квадрат на плоскости координат: %d%n", X, Y, sq );
        if (sq == 0)
            System.out.printf("Координаты (X,Y): (%d, %d)%n" +
                    "Точка находится на оси.%n", X, Y );

    }
    public static void Ex3 () throws IOException{
        System.out.println("3) Пользователь вводит 3 числа (A, B и С). Выведите их в консоль в порядке возрастания.");
        int A = numInput();
        int B = numInput();
        int C = numInput();
        System.out.printf("Число А: %d%nЧисло В: %d%nЧисло С: %d%n", A, B, C);
        System.out.printf("Упорядочивание по возрастанию: %d %d %d%n",
                A > B && A > C? A: B > A && B > C ? B : C > A && C > B ? C: 0,
                A > B && A < C? A: B < A && B > C ? B : C < A && C > B ? C:
                A < B && A > C? A: B > A && B < C ? B : C > A && C < B ? C: 0,
                A < B && A < C? A: B < A && B < C ? B : C < A && C < B ? C: 0);
    }

    public static void Ex4 () throws IOException {
        System.out.println("4) Пользователь вводит 3 числа (A, B и С). " +
                "Выведите в консоль решение(значения X) квадратного уравнения стандартного вида, где AX2+BX+C=0.");
        int A = numInput();
        int B = numInput();
        int C = numInput();
        System.out.printf("Квадратное уравнение: %d * X2 + %d * X + %d = 0%n", A, B,C);
        int D = B * B - 4 * A * C;
        if (D == 0)
            System.out.printf("X = %.2f%n",   ((double)-B / 2 * A) );
        if (D < 0)
            System.out.println("Корней нет.");
        if (D > 0)
            System.out.printf("X1 = %.2f, X2 = %.2f%n",
                    (((double)- B + Math.sqrt(D))/ 2 * A), (((double)- B - Math.sqrt(D))/ 2 * A) );


    }
    public static void Ex5 () throws IOException{
        System.out.println(  "5) Пользователь вводит двузначное число. " +
                "Выведите в консоль прописную запись этого числа. " +
                "Например при вводе “25” в консоль будет выведено “двадцать пять”.");

        int Y = numInput();
        int dec = Y / 10;
        int ed = Y % 10;
        String decStr = null;
        String edStr = null;
        String edod = switch (Y) {
            case 11 -> "одиннадцать";
            case 12 -> "двенадцать";
            case 13 -> "тринадцать";
            case 14 -> "четырнадцать";
            case 15 -> "пятнадцать";
            case 16 -> "шестнадцать";
            case 17 -> "семнадцать";
            case 18 -> "восемнадцать";
            case 19 -> "девятнадцать";
            default -> null;
        };
        switch (dec) {
            case 2 -> decStr = "двадцать";
            case 3 -> decStr = "тридцать";
            case 4 -> decStr = "сорок";
            case 5 -> decStr = "пятьдесят";
            case 6 -> decStr = "шестьдесят";
            case 7 -> decStr = "семьдесят";
            case 8 -> decStr = "восемьдесят";
            case 9 -> decStr = "девяносто";
        }
        switch (ed) {
            case 1 -> edStr = "один";
            case 2 -> edStr = "два";
            case 3 -> edStr = "три";
            case 4 -> edStr = "четыре";
            case 5 -> edStr = "пять";
            case 6 -> edStr = "шесть";
            case 7 -> edStr = "семь";
            case 8 -> edStr = "восемь";
            case 9 -> edStr = "девять";
        }
        if (Y < 20)
        System.out.printf("Двухзначное число: %d%nПрописью: %s%n", Y, edod);
        if (Y > 20)
        System.out.printf("Двухзначное число: %d%nПрописью: %s %s%n", Y, decStr, edStr);
    }
    public static void Ex6 () throws IOException{
        System.out.println("6) Определить, попадает ли точка M(x,y) в круг радиусом r с центром в точке (x0,y0)");
        System.out.println("Введите x точки:");
        int x = numInput();
        System.out.println("Введите y точки:");
        int y = numInput();
        System.out.println("Введите радиус области:");
        int r = numInput();
        System.out.println("Введите x середины области:");
        int x0 = numInput();
        System.out.println("Введите y середины области:");
        int y0 = numInput();
        System.out.printf("Точка М (х,у): (%d, %d) %nРадиус области: %d%n" +
                "Точка середины области: (%d, %d)%n", x, y, r, x0, y0);
        if ((x > 0 && x > x0 + r)|| (x < 0 && x < x0 + r) || (y > 0 && y > y0 + r)|| (y < 0 && y < y0 + r)  ) {
            System.out.println("Не в круге.");
        }
                else {
            System.out.println("В круге.");

            }

    }

    public static void Ex7 () throws IOException{
        System.out.println("7) Написать программу, которая печатает True или False в зависимости от того, " +
                "выполняются или нет заданные условия:\n" +
                "* квадрат заданного трехзначного числа равен кубу суммы цифр этого числа;\n" +
                "* сумма двух первых цифр заданного четырехзначного числа равна сумме двух его последних цифр;\n" +
                "* среди цифр заданного трехзначного числа есть одинаковые;\n" +
                "* среди первых трех цифр из дробной части заданного положительного " +
                "вещественного числа есть цифра 0.\n");

        System.out.println("Введите 3-значное число: ");
        System.out.println(compare3(numInput()));
        System.out.println("Введите 4-х значное число: ");
        System.out.println(compare4half(numInput()));
        System.out.println("Введите 3-значное число: ");
        System.out.println(findSim(numInput()));
        System.out.println("Введите положительное вещественное число: ");
        double Dnum = DnumInput();
        System.out.println((Dnum != 0.0? findNull(Dnum): "" ));

    }
public static boolean compare3 (int num){
    return (num * num) == Math.pow((num % 10 + num % 100 + num % 1000), 3);
}
    public static boolean compare4half (int num){

        return (num % 10 + ((num/10) % 10)) == (num/100 % 10 + num/1000 % 10);
    }
    public static boolean findSim (int num){
        int ed = num % 10;
        int dec = (num/10)%10;
        int cent = num/100;
        return (ed == dec) || (dec == cent) || (ed == cent);
    }
    public static boolean findNull (double num) {

        int drob3 =  (int) ((num % 1) * 1000);
        return ((drob3 % 10) == 0) || ((drob3 / 100) == 0) || (((drob3 / 10) % 10) == 0);
    }

    public static int numInput () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                return Integer.parseInt(reader.readLine());
    }
    public static double DnumInput () throws NumberFormatException {
        double Dnum = 0.0;
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Dnum = Double.parseDouble(reader.readLine());

        }
        catch (Exception e){
            System.out.println("Ошибка ввода!! Проверьте правильность написания разделительного знака!");
        }
            return Dnum;
    }
    public static String strInput () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                return reader.readLine();
    }

}
