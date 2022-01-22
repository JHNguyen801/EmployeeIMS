package Model;

/*
    Abstract class employee contains the variables of employees with a
    default constructor, an alternative constructor, getters and setters methods
 */
public abstract class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String hireDate;
    private String status;

    // Default contstructor
    public Employee() {
        employeeID = 1;
        firstName = "";
        lastName = "";
        hireDate = "";
        status = "";
    }

    // Class constructor stores class variables
    public Employee(int id, String fName, String lName, String hDate, String st ){
        employeeID = id;
        firstName = fName;
        lastName = lName;
        hireDate = hDate;
        status = st;
    }

    // getters and setters method
    public int getEmployeeId() {
        return employeeID;
    }

    public void setId(int id) {
        employeeID = id;
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
}
