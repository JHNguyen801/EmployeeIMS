package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EmployeeDetailTest {
    // Test to see the constructor store data correctly
    @Test
    public void storeData() throws CustomException {
        EmployeeDetail employeeDetail = new EmployeeDetail(1, "Han", "Solo",
                "04/01/2015", "active");
        Assertions.assertEquals("Han", employeeDetail.getFirstName());
    }

    @Test
    void getInfo() throws CustomException {
        List<EmployeeDetail> employeeList = new ArrayList<>();
        int employeeId = 1;
        String firstName = "Jake";
        String lastName = "Lee";
        String hireDate = "01/15/2021";
        String status = "active";
        employeeList.add(new EmployeeDetail(employeeId, firstName, lastName, hireDate, status));
        Assertions.assertEquals(1,employeeId);
        Assertions.assertEquals("Jake",firstName);
        Assertions.assertEquals("Lee",lastName);
        Assertions.assertEquals("01/15/2021",hireDate);
        Assertions.assertEquals("active",status);
    }
}