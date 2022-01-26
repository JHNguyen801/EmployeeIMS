package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeOutput {

    // A method to write a user input into a text file
    public Boolean saveOutput(List<EmployeeDetail> employeeList) throws CustomException, IOException {
        boolean status = true;
        File filename = new File("src/data/employee.csv");

        for(EmployeeDetail emp : employeeList) {
            try(FileWriter fw = new FileWriter(filename, true);
                PrintWriter myWriter = new PrintWriter(fw);) {
                myWriter.print("\n" + emp.getEmployeeID() + "," + emp.getFirstName() + "," + emp.getLastName() +
                        "," + emp.getHireDate() + "," + emp.getStatus());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                status = false;
            }
        }
        return status;
    }
}
