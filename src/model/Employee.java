package model;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
    Abstract class employee contains the variables of employees with a
    default constructor, an alternative constructor, getters and setters methods,
    and an abstract method getInfo()
 */
public abstract class Employee {
    // class variables
    private int employeeID;
    private String firstName;
    private String lastName;
    private String hireDate;
    private String status;
    private static final AtomicInteger count = new AtomicInteger(0);

    // Default contstructor
    public Employee(){
        employeeID = count.incrementAndGet();
        firstName = "";
        lastName = "";
        hireDate = "";
        status = "";
    }

    // Overloaded constructor stores class variables
    public Employee(int id, String fName, String lName, String hDate, String st ) throws CustomException {
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

    // getters and setters method
    public int getEmployeeID() {
        return employeeID;
    }
    public int setEmployeeID(int id) {
        return employeeID = id;
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
    public void setHireDate(String hDate) {
        hireDate = hDate;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // abstract get info method
    public abstract List<EmployeeDetail> getInfo() throws CustomException, IOException;
}
