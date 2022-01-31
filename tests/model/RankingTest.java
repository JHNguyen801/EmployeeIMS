package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/* This class is to test the Ranking class method to make sure the method takes the data in the arrayList sort
 * properly in descending order
 */
class RankingTest {

    @Test
    void rank() throws EmployeeIDException {
        EmployeeAdd employeeAdd = new EmployeeAdd();
        Ranking rankEmployee = new Ranking();
        ArrayList<EmployeeAdd> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeAdd(1, "Han", "Do","01/01/2015", 50000.0,"active"));
        employeeList.add(new EmployeeAdd(2, "Bo", "Chan","11/01/2021", 55000.0,"active"));
        employeeList.add(new EmployeeAdd(3, "Steve", "Low","11/01/2001", 65000.0,"inactive"));
        rankEmployee.rank(employeeList);
    }
}
