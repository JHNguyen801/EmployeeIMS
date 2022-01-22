package Test;

import Model.Employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    public void display() {
        Employee[] emp = {new Employee(1, "Adam", "Lang",
                "06/13/2016", "Inactive") {
        }, new Employee(2, "Jake", "Smith", "01/01/2015", "Active") {
                    @Override
                    public int getEmployeeId() {
                        return super.getEmployeeId();
                    }
                }};
        Assertions.assertEquals(1,emp);
    }

}