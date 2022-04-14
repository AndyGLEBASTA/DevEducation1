package Cycles;


import java.io.IOException;


public class Solution extends InOut implements ExStr {
    public static void main(String[] args) throws IOException {
        System.out.println(theme + ex1 + ex2+ ex3+ ex4+ ex5+ ex6+ ex7+ ex8+ ex9+ ex10
                + ex11+ ex12+ ex13+ ex14+ ex15+ ex16+ ex17+ ex18+ ex19+ ex20+ ex21+ ex22 + ex23 + inputStr);
        switcher();

    }
public static void switcher () throws IOException {
    String ex = strInput();
    while(!ex.equals("exit")) {

        switch (ex) {
            case "1" -> Exercises.Ex1();
            case "2" -> Exercises.Ex2();
            case "3" -> Exercises.Ex3();
            case "4" -> Exercises.Ex4();
            case "5" -> Exercises.Ex5();
            case "6" -> Exercises.Ex6();
            case "7" -> Exercises.Ex7();
            case "8" -> Exercises.Ex8();
            case "9" -> Exercises.Ex9();
            case "10" -> Exercises.Ex10();
            case "11" -> Exercises.Ex11();
            case "12" -> Exercises.Ex12();
            case "13" -> Exercises.Ex13();
            case "14" -> Exercises.Ex14();
            case "15" -> Exercises.Ex15();
            case "16" -> Exercises.Ex16();
            case "17" -> Exercises.Ex17();
            case "18" -> Exercises.Ex18();
            case "19" -> Exercises.Ex19();
            case "20" -> Exercises.Ex20();
            case "21" -> Exercises.Ex21();
            case "22" -> Exercises.Ex22();
            case "23" -> Exercises.Ex23();

            default ->
                System.out.println("Ошибка ввода! Попробуйте ещё раз.");

        }
        ex = strInput();

    }
}

}
