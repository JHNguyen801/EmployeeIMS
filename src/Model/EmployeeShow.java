package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeShow extends Employee {
    public  void viewFile(String s){
        File file = new File("src/employee.text");
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
    // Display method print salary employee information
    public void displayEmployeeInfo(String s){
        System.out.println("List of Hourly Employees");
        System.out.println("\tEmployee ID: " + getEmployeeId()  + "\t First Name: " + getFirstName() +
                "\t Last Name: " + getLastName() + "\t Hired Date: " + getHireDate() +
                "\t Status: " + getStatus());
    }
}
