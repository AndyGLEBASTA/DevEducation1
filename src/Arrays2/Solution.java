package Arrays2;

import java.util.Random;

public class Solution {

    public static void main(String[] args) {

        int [][]arr = inputArray(4,6,0,99);
        int min = findMin(arr);
        int max = findMax(arr);
        System.out.println("Массив:");
        printArr(arr);
        System.out.println("Минимальный элемент массива:");
        printNum(min);
        System.out.println("Максимальный элемент массива:");
        printNum(max);
        System.out.println("Индекс мин элемента: " + indexMin(arr));
        System.out.println("Индекс макс элемента: " + indexMax(arr));

        printNum(allAlphas(arr));
        int [][]arr2 = inputArray(5,5,0,99);
        System.out.println("Новый квадратный ассив:");
        printArr(arr);
        mirror(arr2);


    }
    public static int [][] inputArray (int n, int m, int a, int b){

        int [][ ] arr = new int[n][m];
        Random random = new Random();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                arr[i][j] = random.nextInt(a, b);
            }
        }
        return arr;
    }
    public static int findMin (int [][] arr) {
        int x = arr.length;
        int y = arr[0].length;
        int min = arr [0] [0];
        for (int i = 0;  i < x; i++){
            for (int j = 0; j < y; j++){
                if (arr[i][j] < min)
                    min = arr [i][j];
            }

        }
        return min;
    }

    public static int findMax (int [][] arr) {
        int x = arr.length;
        int y = arr[0].length;
        int max = arr [0] [0];
        for (int i = 0;  i < x; i++){
            for (int j = 0; j < y; j++){
                if (arr[i][j] > max)
                    max = arr [i][j];
            }

        }
        return max;
    }
    public static String indexMin (int [][] arr){
        String iMin = null;
        int x = arr.length;
        int y = arr[0].length;
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                if (arr[i][j] == findMin(arr)){
                    iMin = String.format("[%d][%d]", i, j);
                }
            }
        }
        return iMin;
    }
    public static String indexMax (int [][] arr){
        int x = arr.length;
        int y = arr[0].length;
        String iMax = null;
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                if (arr[i][j] == findMax(arr)){
                    iMax = String.format("[%d][%d]", i, j);
                }
            }
        }
        return iMax;
    }
    public static int allAlphas (int [][] arr){
        int allA = 0;
        int x = arr.length;
        int y = arr[0].length;
        System.out.println("Самые большие элементы среди ближайших:");
        for (int i = 1; i < x - 1; i++) {
            if (arr[i][0] > arr[i - 1][0]
                    && arr[i][0] > arr[i + 1][0]
                    && arr[i][0] > arr[i + 1][1]
                    && arr[i][0] > arr[i - 1][1]
                    && arr[i][0] > arr[i][1]) {
                System.out.printf("[%d][0]%n", i);
                allA++;
            }
        }
        for (int i = 1; i < x - 1; i++) {
            if (arr[i][y - 1] > arr[i - 1][y - 1]
                    && arr[i][y - 1] > arr[i + 1][y - 1]
                    && arr[i][y - 1] > arr[i + 1][y - 2]
                    && arr[i][y - 1] > arr[i - 1][y - 2]
                    && arr[i][y - 1] > arr[i][y - 2]) {
                System.out.printf("[%d][%d]%n", i, y - 1);
                allA++;
            }
        }
        for (int i = 1; i < y - 1; i++) {
            if (arr[0][i] > arr[0][i - 1]
                    && arr[0][i] > arr[0][i + 1]
                    && arr[0][i] > arr[1][i + 1]
                    && arr[0][i] > arr[1][i - 1]
                    && arr[0][i] > arr[1][i]) {

                System.out.printf("[0][%d]%n", i);
                allA++;
            }
        }
        for (int i = 1; i < y - 1; i++){
            if (arr[x - 1][i] > arr[x - 1][i - 1]
                    && arr[x - 1][i] > arr[x - 1][i + 1]
                    && arr[x - 1][i] > arr[x - 2][i + 1]
                    && arr[x - 1][i] > arr[x - 2][i]
                    && arr[x - 1][i] > arr[x - 2][i - 1] )

            {
                System.out.printf("[%d][%d]%n", x - 1, i);
                allA++;
            }
        }
        for (int i = 1; i < x - 1; i++){

            for (int j = 1; j < y - 1; j++){

                if (arr[i][j] > arr [i][j - 1] && arr[i][j] > arr [i][j + 1]
                        && arr[i][j] > arr [i - 1][j] && arr[i][j] > arr [i + 1][j]
                        && arr[i][j] > arr [i + 1][j + 1] && arr[i][j] > arr [i - 1][j - 1]
                        && arr[i][j] > arr [i - 1][j + 1] && arr[i][j] > arr [i + 1][j - 1]) {

                    System.out.printf("[%d][%d]%n", i, j);


                    allA++;
                }
            }
        }
        if (arr[0][0] > arr [0][1]
                && arr[0][0] > arr [1][0]
                && arr[0][0] > arr [1][1]) {
            System.out.println("[0][0]");
            allA++;
        }
        if (arr[0][y - 1] > arr [0][y - 2]
                && arr[0][y - 1] > arr [1][y - 1]
                && arr[0][y - 1] > arr [1][y - 2])
        {
            System.out.printf("[0][%d]%n",y - 1);
            allA++;
        }
        if (arr[x - 1][0] > arr [x - 1][1]
                && arr[x - 1][0] > arr [x - 2][0]
                && arr[x - 1][0] > arr [x - 2][1])
        {
            System.out.printf("[%d][0]%n", x - 1);
            allA++;
        }
        if (arr[x - 1][y - 1] > arr [x - 2][y - 1]
                && arr[x - 1][y - 1] > arr [x - 1][y - 2]
                && arr[x - 1][y - 1] > arr [x - 2][y - 2])
        {
            System.out.printf("[%d][%d]%n", x - 1, y - 1);
            allA++;
        }

        System.out.println("Кол-во этих элементов: ");
        return allA;
    }

    public static void printArr(int [][]arr ){
        for (int i = 0;  i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printNum (int min){
        System.out.println(min);
    }

    public static void mirror (int [][] arr) {
        int [][] arrm = arr;
        int x = arrm.length;
        int y = arrm[0].length;
        int k = 0;

        for (int i = 0; i < x - 1; i++) {
            for (int j = y - 1; j > k; j--) {
                int temp = arrm[i][j];
            arrm[i][j] = arrm[j][i];
              arrm[j][i] = temp;
            }
             k++;
        }
        System.out.println("Массив отражённый:");
        printArr(arrm);
    }


}
