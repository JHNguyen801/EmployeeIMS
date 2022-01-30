package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
    This class contains the test method to check the list save to the output file
 */
class EmployeeOutputTest {
    @Test
    void saveOutput() throws IOException, EmployeeIDException {
        List<EmployeeDetail> employeeList = new ArrayList<>();
        EmployeeDetail ed = new EmployeeDetail();
        EmployeeOutput eo = new EmployeeOutput();
        employeeList.add(new EmployeeDetail(1, "Han", "Do","01/01/2015", 50000.0,"active"));
        employeeList.add(new EmployeeDetail(2, "Bo", "Chan","11/01/2021", 55000.0,"active"));
        employeeList.add(new EmployeeDetail(3, "Steve", "Low","11/01/2001", 65000.0,"inactive"));
        eo.saveOutput(employeeList);
    }
}