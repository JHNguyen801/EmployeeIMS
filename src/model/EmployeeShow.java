package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeShow {
    ArrayList<Staff> employeeList = new ArrayList<>();
    public  void viewFile(String s){
        File file = new File("src/data/employee.text");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
        catch (FileNotFoundException nf){
            System.out.println("File not found");
        }
    }
    // a method read a text file
    public  void showEmployeeInfo() throws IOException {
        File file = new File("src/data/employee.text");
        try {
            Scanner sc = new Scanner(file);
            // Declaring a string variable
            String st;
            // Condition holds true till there is character in a string
//            while ((st = br.readLine()) != null){
//                // Print the string
//                System.out.println(st);
//
//            }
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (NumberFormatException e){
            System.out.println(e);
        }
    }
}
