package model;

import data.TextHandling;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class EmployeeOutput extends EmployeeDetail {

    // Write a user input into a text file
    public void addEmployee() throws CustomException {
        EmployeeDetail emp = new EmployeeDetail();
//        TextHandling data = new TextHandling();
        emp.getInfo();
        File filename = new File("src/data/employee.text");
        try{
            Scanner add = new Scanner(System.in);
            PrintWriter myWriter = new PrintWriter(filename);
            myWriter.print("\n\tList of Hourly Employees\n");
            myWriter.print("*******************************************");
            myWriter.print("\nEmployee ID: "+ emp.employeeID + "\nFirst Name: "
                    +emp.firstName+ "\nLast Name: " + emp.lastName +
                    "\nHire Date: " + emp.hireDate + "\nEmployee Status: " + emp.status);
            myWriter.close();
            System.out.print("\nPress Enter to Continue...");
            add.nextLine();
        }
        catch(Exception e){System.out.println(e);}
    }

//    public void saveEmployeeInfo() throws FileNotFoundException {
//        String filePath = "files" + File.separator+"employee.txt";
//        PrintWriter outfilepw = new PrintWriter(filePath);
//    }
}
