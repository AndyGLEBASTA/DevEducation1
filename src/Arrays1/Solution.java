package Arrays1;

import java.util.Random;

public class Solution {

    public static void main(String[] args) {

        int[] arr = inputArray(9, 0, 99);
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
        System.out.println("Сумма элементов массива с нечетными индексами: " + sumOddInd(arr));



    }
    public static int [] inputArray (int n, int a, int b){

        int [] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++){

                arr[i] = random.nextInt(a, b);
        }
        return arr;
    }
    public static int findMin (int [] arr) {

        int min = arr[0];
        for (int j : arr) {

            if (j < min)
                min = j;
        }


        return min;
    }

    public static int findMax (int [] arr) {

        int max = arr [0];
        for (int j : arr) {

            if (j > max)
                max = j;


        }
        return max;
    }
    public static String indexMin (int [] arr){
        String iMin = "";
        int x = arr.length;
        for (int i = 0; i < x; i++){

                if (arr[i] == findMin(arr)){
                    iMin = String.format("[%d]", i);
                }

        }
        return iMin;
    }
    public static String indexMax (int [] arr){
        int x = arr.length;

        String iMax = null;
        for (int i = 0; i < x; i++){

                if (arr[i] == findMax(arr)){
                    iMax = String.format("[%d]", i);
                }

        }
        return iMax;
    }
    public static int sumOddInd (int []arr){
        int sum = 0;
        for (int i = 1; i < arr.length; i += 2)
            sum += arr[i];
        return sum;
    }
    public static void printArr(int []arr ){
        for (int j : arr) {

            System.out.print(j + " ");
        }
            System.out.println();

    }
    public static void printNum (int min){
        System.out.println(min);
    }

}

