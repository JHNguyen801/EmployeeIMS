package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/*
    EmployeeUpdate class is reading the data and update the employee
    information. It is not yet implement.
 */
public class EmployeeUpdate
{
    ArrayList<EmployeeDetail> employeeList = new ArrayList<>();
    EmployeeShow employeeShow = new EmployeeShow();
    EmployeeDetail ed = new EmployeeDetail();

    public double updateEmployee(int s){
        Scanner sc = new Scanner(System.in);
        employeeShow.readDataFromFile();
        double sortSalary = 0;
        for(int i = 0; i < employeeList.size(); i++){
            if(s == ed.getEmployeeID()){
                System.out.println("Please enter a new salary");
                sortSalary = sc.nextDouble();
                ed.setSalary(sortSalary);
            }
        }
        return sortSalary;
    }
}
