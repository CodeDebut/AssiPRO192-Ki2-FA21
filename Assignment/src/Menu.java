/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LONG
 */
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Menu<E> {

    public Menu() {
    }

    int response;
    Scanner sc = new Scanner(System.in);

    public int int_getChoice(ArrayList<E> options) {
        for (E o : options) {
            System.out.println(o);

        }

        System.out.println("Please choose an option 1 to 11");
        System.out.print("My choice is: ");

        try {
            response = Integer.parseInt(sc.nextLine());

        } catch (Exception e) {
            System.out.println("An option would be int");
        }

        return response;
    }

    public E ref_getChoice(ArrayList<E> options) {
        do {
            response = int_getChoice(options);
        } while (response < 0 || response > 11);
        return options.get(response - 1);
    }

}
