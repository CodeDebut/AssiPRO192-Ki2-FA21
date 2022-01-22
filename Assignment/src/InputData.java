
import java.lang.*;
import java.util.*;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LONG
 */
public class InputData {

    public static Scanner sc = new Scanner(System.in);

    public static String nomalization(String s) {
        StringTokenizer k = new StringTokenizer(s, " ");
        String result = k.nextToken();
        while (k.hasMoreElements()) {
            result += k.nextToken();
        }
        return result;
    }

    public static String getNonBlankStr(String str) {
        String result;
        do {
            System.out.print(str);
            result = sc.nextLine().trim();
        } while (result.length() == 0);

        return result;
    }

    public static double getIntPos(String s, int i) {
        double result;
        do {
            System.out.print(s);
            result = Double.parseDouble(sc.nextLine());
        } while (result <= i);
        return result;

    }

    public static String getPatternStr(String s, String reEx) {
        String result;
        do {
            System.out.print(s);
            result = nomalization(sc.nextLine());
        } while (!result.matches(reEx));
        return result;
    }

    public static String getPatternStrnotBlank(String s, String reEx) {
        String result;
        do {
            System.out.print(s);
            result = nomalization(sc.nextLine());
        } while (!result.matches(reEx) && !result.matches(reEx));
        return result;
    }

}
