package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomExceptionTest {

    @Test
    void checkId() {
        EmployeeDetail employeeDetail = new EmployeeDetail();
        int employId = employeeDetail.setEmployeeID(1);
        if(employId >= 1) {
            assertEquals(1, employId);
        }
    }
}