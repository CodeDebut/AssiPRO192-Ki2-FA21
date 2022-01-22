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
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrandList extends ArrayList<Brand> {

    final int MAX = 100; // hằng số quy định kích thước tối đa của mảng List[]

    int numOfBrand = 0; // biến lưu số phần tử hiện thời của mảng list[]

    public BrandList() {
    }

    public boolean loadFromFile(String filename) throws IOException {
        BufferedReader br = null;
        try {
            File file = new File(filename);
            br = new BufferedReader(new FileReader(file)); //br để đọc
            String string;
            while ((string = br.readLine()) != null) {
                String[] words = string.split(","); //split ngăn cách
                String brand_id = words[0].trim();
                String brand_name = words[1].trim();
                String[] words2 = words[2].trim().split(":");
                String soundBrand = words2[0].trim();
                double price = Double.parseDouble(words2[1].trim());
                Brand brand = new Brand(brand_id, brand_name, soundBrand, price);
                this.add(brand);
            }
            numOfBrand = this.size();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BrandList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(BrandList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    public boolean saveToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            for (Brand p : this) {
                pw.println(p);
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public int searchID(String bID) {
        for (int i = 0; i < numOfBrand; i++) {
            if (this.get(i).getBrandID().equalsIgnoreCase(bID)) {
                System.out.println("Brand result is shown");
                return i;
            }

        }
        System.out.println("Not found");
        return -1;
    }

    public Brand getUserChoice() {
        Menu mnu = new Menu();
        return (Brand) mnu.ref_getChoice(this);
    }

    public void addBrand() {
        String brandID, brandName, soundBrand;
        double price;
        if (numOfBrand >= MAX) {
            System.out.println("List[] array reaches maximum number of elements. Cannot add anymore");
            return;
        }
        boolean duplicate = false;
        String msg = "Input brandID: ";
        do {
            brandID = InputData.getNonBlankStr(msg);
            brandID = brandID.toUpperCase();
            duplicate = (search(brandID) == 1);
            if (duplicate) {
                System.out.println("brandID can not be duplicated!");
            }
        } while (duplicate);
        brandName = InputData.getNonBlankStr("Input product name: ");
        soundBrand = InputData.getNonBlankStr("Input soundBrand: ");
        price = InputData.getIntPos("Input product's price: ", 0);
        Brand np = new Brand(brandID, brandName, soundBrand, price);
        this.add(np);
        numOfBrand++;
        System.out.println("A new item is add.");
    }

    public void updateBrand() {
        String brandID, brandName, soundBrand;
        double price;
        boolean duplicate = false;
        String bI = "Input brandID: ";
        brandID = InputData.getNonBlankStr(bI);
        brandID = brandID.toUpperCase();
        int pos = searchID(brandID);
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            brandName = InputData.getNonBlankStr("Input product name: ");
            soundBrand = InputData.getNonBlankStr("Input soundBrand: ");
            price = InputData.getIntPos("Input product's price: ", 0);

            this.set(pos, new Brand(brandID, brandName, soundBrand, price));
            System.out.println("Updated is successfully");
        }

    }

    public void listBrands() {
        for (int i = 0; i < numOfBrand; i++) {
            System.out.println(this.get(i));
        }
    }

    public int search(String brandID) {
        brandID = InputData.nomalization(brandID).toUpperCase();
        for (Brand p : this) {
            if (p.brandID.equals(brandID)) {
                return 1;
            }
        }
        return -1;
    }
}
