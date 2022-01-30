package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankingTest {

    @Test
    void rank() throws EmployeeIDException {
        EmployeeDetail employeeDetail = new EmployeeDetail();
        ArrayList<EmployeeDetail> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeDetail(1, "Han", "Do","01/01/2015", 50000.0,"active"));
        employeeList.add(new EmployeeDetail(2, "Bo", "Chan","11/01/2021", 55000.0,"active"));
        employeeList.add(new EmployeeDetail(3, "Steve", "Low","11/01/2001", 65000.0,"inactive"));
        Ranking.rank(employeeList);
    }
}