/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LONG
 */
import java.util.Scanner;
import java.lang.*;
import java.util.*;
import java.io.*;

public class CarManager {

    public static void main(String[] args) throws IOException {
        int choice = 0;
        BrandList brandList = new BrandList();
        brandList.loadFromFile("D:\\AssigFilePRO192\\brands.txt");
        CarList Car = new CarList();
        Car.loadFromFile("D:\\AssigFilePRO192\\cars.txt");

        ArrayList<String> ops = new ArrayList<>();
        ops.add("\n1-List all brands");
        ops.add("2-Add a new brand");
        ops.add("3-Search a brand based on its ID");
        ops.add("4-Update a brand");
        ops.add("5-Save brands to the file, named brands.txt");
        ops.add("6-List all cars in ascending order of brand names");
        ops.add("7-List cars based on a part of an input brand name");
        ops.add("8-Add a car");
        ops.add("9-Remove a car based on its ID");
        ops.add("10-Update a car based on its ID");
        ops.add("11-Save cars to file, named Cars.txt");

        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        do {
            choice = menu.int_getChoice(ops);
            switch (choice) {
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                    System.out.print("BrandID= ");
                    String bID = sc.nextLine();
                    brandList.searchID(bID);
                    break;
                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    brandList.saveToFile("D:\\AssigFilePRO192\\brands.txt");
                    break;
                case 6:
                    Car.listCars();
                    break;

                case 7:
                    System.out.print("Input PartOfBrandName: ");
                    String PartOfBrandName = sc.nextLine();
                    Car.printBasedBrandName(PartOfBrandName);
                    break;
                case 8:
//                    Car.addCar();
                    break;
                case 9:
                    Car.removeCar();
                    break;
                case 10:
                    Car.updateCar();
                    break;
                case 11:
                    Car.saveToFile("D:\\AssigFilePRO192\\cars.txt");
                    break;

            }
        } while (choice > 0 && choice <= ops.size());
    }
}
