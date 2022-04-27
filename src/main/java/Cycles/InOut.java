package Cycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InOut {
    public static int numInput () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }
    public static String strInput () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
    public static double DnumInput () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(reader.readLine());
    }
}
