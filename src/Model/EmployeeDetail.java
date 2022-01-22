package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDetail extends Employee {
    int employeeID;
    String firstName;
    String lastName;
    String hireDate;
    String status;
    ArrayList<Employee> emp;

    public EmployeeDetail(){
        employeeID = 0;
        firstName = "";
        lastName = "";
        hireDate = "";
        status = "";
    }

    public ArrayList<Employee> getEmp() {
        return emp;
    }

    public void setEmp(ArrayList<Employee> emp) {
        this.emp = emp;
    }

    EmployeeDetail(int id, String fName, String lName, String hDate, String st){
        super(id, fName, lName, hDate, st);
    }

    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        employeeID = sc.nextInt();
        System.out.print("Enter First Name: ");
        firstName = sc.next();
        System.out.print("Enter Last Name: ");
        lastName = sc.next();
        System.out.print("Enter Hired Date: ");
        hireDate = sc.next();
        System.out.print("Enter Status: ");
        status = sc.next();
    }
}
