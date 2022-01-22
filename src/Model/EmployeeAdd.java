package Model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeAdd extends EmployeeDetail {
    public void addEmployee(){
        Scanner add = new Scanner(System.in);
        EmployeeDetail emp = new EmployeeDetail();
        emp.getInfo();
        try {
            File f = new File("src/employee.text");
            if (f.createNewFile()) {
                FileWriter fw = new FileWriter("src/employee.text");
                fw.write("Employee ID: " + emp.getEmployeeId() + "\t" +
                        "First Name: " + emp.getFirstName() + "\t" +
                        "Last Name: " + emp.getLastName() + "\t" +
                        "Hired Date: " + emp.getHireDate() + "\t" +
                        "Status: " + emp.getStatus());
            fw.close();
            System.out.println("\nEmployee has been added");
        }
            else {
                System.out.println("\n Employee already on file");
                System.out.println("Press enter to continue...");
                add.nextLine();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
