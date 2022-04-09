package Cycles;

import java.io.IOException;

public class Exercises extends InOut implements ExStr{
    public static void Ex1() throws IOException {
        System.out.print(ex1);
        int A = numInput();
        int B = numInput();
        int C = A;
                for (int i = 2; i <= B; i++)
            C *= A;
        System.out.printf("Решение:\nA - число: %d\nB - степень числа: %d\nОтвет: %d\n", A, B, C);
    }
    public static void Ex2() throws IOException {
        System.out.print(ex2);
        int A = numInput();
        int temp = 0;
        boolean flag = false;
        System.out.printf("Решение:\nA - число: %d\nВсе числа от 1 до 1000, которые делятся на А:\n", A);
                for (int i = 1; i <= 1000; i++) {
            if ((double)i % A == 0) {
                temp++;
                flag = true;
                System.out.print(i + " ");
            }
                    if (temp % 10 == 0 && flag) {
                        System.out.println("");
                        flag = false;
                    }
        }
        if (flag)
        System.out.println("");
    }
    public static void Ex3() throws IOException {
        System.out.print(ex3);
        int A = numInput();
        int temp = 0;
        for (int i = 1; i < A; i++) {
if(Math.sqrt(i) % 1 == 0)
    temp++;
        }
        System.out.printf("Решение:\nA - число: %d\n" +
                "Количество положительных целых чисел, квадрат которых меньше A: %d\n", A, temp);
    }
    public static void Ex4() throws IOException {
        System.out.print(ex4);
        int A = numInput();
        int max = 0;
        for (int i = 1; i < A; i++) {
            if(((double)A / i) % 1 == 0 && i > max)
                max = i;
        }
        System.out.printf("Решение:\nA - число: %d\n" +
                "Наибольший делитель (кроме самого A): %d\n", A, max);
    }
    public static void Ex5() throws IOException {
        System.out.print(ex5);
        int A = numInput();
        int B = numInput();
        int sum = 0;
            if (A < B) {
            for (int i = A + 1; i < B; i++) {
                if ( i % 7 == 0)
                    sum +=  i;
            }
            System.out.printf("Решение:\nA - число: %d\nB - число: %d\n" +
                    "Сумма всех чисел из диапазона от A до B, которые делятся без остатка на 7: %d\n", A, B, sum);
        }
        if (A > B) {
            for (int i = B + 1; i < A; i++) {
                if (i % 7 == 0)
                    sum += i;
            }
            System.out.printf("Решение:\nA - число: %d\nB - число: %d\n" +
                    "Сумма всех чисел из диапазона от A до B, которые делятся без остатка на 7: %d\n", A, B, sum);
        }
        if (A == B) {
            System.out.println("A = B. Попробуйте в другой раз.");
        }

    }
    public static void Ex6() throws IOException {
        System.out.print(ex6);
        int N = numInput();
        if (N == 1)
            System.out.println(1);
        if (N == 0)
            System.out.println("Перезапустите задание и введите целое позитивное число.");
        if (N >= 2) {
            int Fib = 1;
            int FPast = 0;
            int temp;
            for (int i = 2; i <= N; i++) {
                temp = FPast;
                FPast = Fib;
                Fib += temp;
            }
            System.out.printf("Решение:\nN - число: %d\n" +
                    "N-ое число ряда фибоначчи: %d\n", N, Fib);
        }
    }
    public static void Ex7() throws IOException {
        System.out.print(ex7);
        int A = numInput();
        int B = numInput();
        System.out.printf("Решение:\nA - число: %d\nB - число: %d\n", A, B);
        while (A != 0 && B != 0){
            if (A > B){
                A = A % B;}
            else {
                B = B % A;}
        }
        System.out.printf("Наибольший общий делитель по алгоритму Евклида: %d\n", A + B);
    }
    public static void Ex8() throws IOException {
        System.out.print(ex8);
        int A = numInput();
        System.out.printf("Решение:\nКуб целого числа N: %d\n", A);
        for (int N = 1; N < (A/2); N++){
            if ((N*N*N) == A)
                System.out.printf("N - число: %d\n", N);
            }

    }
    public static void Ex9() throws IOException {
        System.out.print(ex9);
        int A = numInput();
        System.out.printf("Решение:\nА - число: %d\n", A);
        int temp = 0;
       while(A != 0){
           if ((A % 10) % 2 != 0)
               temp++;
           A /= 10;
       }
        System.out.printf("Кол-во нечётных цифр в числе А: %d\n", temp);
    }
    public static void Ex10() throws IOException {
        System.out.print(ex10);
        String A = strInput();
        System.out.printf("Решение:\nА - число: %s\n", A);
        char[] arr = A.toCharArray();
        char temp;
        for (int i = 0; i <= (arr.length - 1) / 2 ; i++){
          temp = arr[i];
          arr[i] = arr[arr.length - 1 - i];
          arr[arr.length - 1 - i] = temp;
          }
        System.out.printf("Число, которое является зеркальным отображением " +
                "последовательности цифр: %s\n", String.valueOf(arr));
    }
    public static void Ex11() throws IOException {
        System.out.print(ex11);
        int A = numInput();

        System.out.printf("Решение:\nА - число: %s\n" +
                "Числа в диапазоне от 1 до N, сумма четных цифр которых больше суммы нечетных:\n", A);
        for (int i = 1; i <= A; i++){
            int j = i;
            int temp2 = 0;
            int temp1 = 0;
           while(j != 0) {
               if ((j % 10) % 2 == 0)
                   temp2 += (j % 10);
               if ((j % 10) % 2 != 0)
                   temp1 += (j % 10);
           j /= 10;
           }
           if (temp2 > temp1)
            System.out.print(i + " ");
        }
        System.out.println( " ");
    }
    public static void Ex12() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }
    public static void Ex13() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }
    public static void Ex14() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }
    public static void Ex15() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }
    public static void Ex16() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }
    public static void Ex17() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }
    public static void Ex18() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }
    public static void Ex19() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }
    public static void Ex20() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }
    public static void Ex21() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }
    public static void Ex22() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }
    public static void Ex23() throws IOException {
        int A = Solution.numInput();
        int B = Solution.numInput();
        int C = A;
        for (int i = 1; i <= B; i++)
            C *= C * A;
        System.out.println(C);
    }

}
