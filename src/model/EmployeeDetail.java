package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeDetail extends Employee{
    int employeeID;
    String firstName;
    String lastName;
    String hireDate;
    String status;

    private static final AtomicInteger count = new AtomicInteger(1);

    // Default Construtor
    public EmployeeDetail(){
        employeeID = count.incrementAndGet();
        firstName = "";
        lastName = "";
        hireDate = "";
        status = "";
    }

    // Overload constructors store id, first name, last name, hire date, and status
    public EmployeeDetail(int id, String fName, String lName, String hDate, String st ) throws CustomException {
        if(id >= 1){
            employeeID = id;
            count.incrementAndGet();
        }
        else {
            throw new CustomException();
        }
        firstName = fName;
        lastName = lName;
        hireDate = hDate;
        status = st;
    }

    ArrayList<Employee> employeeList = new ArrayList();

    // A method prompt a user to enter input information
    @Override
    public void getInfo()
    {
        Scanner sc=new Scanner(System.in);
//        System.out.print("Enter Employee ID: ");
//        employeeID = Integer.parseInt(sc.nextLine());
        System.out.print("Enter First Name: ");
        firstName=sc.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = sc.nextLine();
        System.out.print("Enter Hired Date: ");
        hireDate = sc.nextLine();
        System.out.print("Enter Status: ");
        status = sc.nextLine();
        System.out.println("Employee information saved sucessful");
        for(Employee e : employeeList) {
            e.setEmployeeID(employeeID);
            e.setFirstName(firstName);
            e.setHireDate(lastName);
            e.setHireDate(hireDate);
            e.setStatus(status);
        }
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID += employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
