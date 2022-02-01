package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeUpdateTest {

    @Test
    void loadData() {
    }

    @Test
    void updateEmployee() throws EmployeeIDException {
        EmployeeAdd ed = new EmployeeAdd(1,"Han","Solo","01/01/2015",34000, "active");
        EmployeeUpdate eu = new EmployeeUpdate();
        ArrayList<EmployeeAdd> employeeList = new ArrayList<>();
        employeeList.add(ed);
        int id = 1;
        double newSalary = 45000;
        ed.setSalary(newSalary);
        eu.updateEmployee(employeeList, id);
    }
}