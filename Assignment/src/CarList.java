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
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarList extends ArrayList<Car> {

    Car[] list;
    int numOfCar; // biến lưu số phần tử hiện thời của mảng list[]
    final int MAX = 100; // hằng số quy định kích thước tối đa của mảng List[]

    BrandList brandList = new BrandList();
    Scanner sc = new Scanner(System.in);

    public CarList() {
    }

    public CarList(BrandList bList) {
        brandList = bList;
    }

    public boolean loadFromFile(String filename) throws IOException {
        BufferedReader br = null;
        try {
            File file = new File(filename);
            br = new BufferedReader(new FileReader(file)); //br để đọc
            String string;
            while ((string = br.readLine()) != null) {
                String[] words = string.split(","); //split ngăn cách
                String car_ID = words[0].trim();
                brandList.loadFromFile("D:\\AssigFilePRO192\\brands.txt");
                int pos = 0;
                for (int i = 0; i < brandList.size(); i++) {
                    if (brandList.get(i).getBrandID().equalsIgnoreCase(words[1].trim())) {
                        pos = i;
                        break;
                    }
                }
                Brand car_brand = brandList.get(pos);
                String color = words[2].trim();
                String frameID = words[3].trim();
                String engineID = words[4].trim();
                Car car = new Car(car_ID, car_brand, color, frameID, engineID);
                this.add(car);
            }
            numOfCar = this.size();
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
            for (Car p : this) {
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

    public int searchID(String carID) {
        for (int i = 0; i < numOfCar; i++) {
            if (this.get(i).getCarID().equalsIgnoreCase(carID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String fID) {
        for (int i = 0; i < numOfCar; i++) {
            if (this.get(i).getFrameID().equalsIgnoreCase(fID)) {
                System.out.println("FramID result is shown");
                return i;
            }
        }
        System.out.println("Not found!");
        return -1;
    }

    public int searchEngine(String eID) {
        for (int i = 0; i < numOfCar; i++) {
            if (this.get(i).getEngineID().equalsIgnoreCase(eID)) {
                System.out.println("EngineID result is shown");
                return i;
            }
        }
        System.out.println("Not found!");
        return -1;
    }

    public void addCar() {
        
    }

    public void printBasedBrandName(String brandname) {
        int count = 0;
        for (int i = 0; i < numOfCar; i++) {
            Car c = this.get(i);
            if (c.brand.brandName.contains(brandname)) {
                System.out.println(c.screenString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No result");
        }
    }

    public boolean removeCar() {
        System.out.print("removedID: ");
        String removedID = sc.nextLine();
        int pos = searchID(removedID);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            remove(pos);
            System.out.println("Remove successfully.");
        }
        return true;
    }

    public boolean updateCar() {
        String carID,brandID,color,frameID,engineID;
        String cI = "updatedID: ";
    
        carID = InputData.getNonBlankStr(cI);
        carID = carID.toUpperCase();
        int pos = searchID(cI);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            
//            brandID = InputData.getNonBlankStr("Input product name: ");
//            color = InputData.getNonBlankStr("Input soundBrand: ");
//            frameID = InputData.getNonBlankStr("Input soundBrand: ");
//            engineID = InputData.getNonBlankStr("Input soundBrand: ");
//            
//           this.set(pos, new Car(carID, brandID, color, frameID, engineID));
//            System.out.println("Updated is successfully");
        }

        return true;
    }

    public void listCars() {
//        Collections.sort();

        for (int i = 0; i < numOfCar - 1; i++) {
            Car c = this.get(i);
            System.out.println(c.screenString());

        }
    }

}
