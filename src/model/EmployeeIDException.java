package model;

import org.junit.platform.commons.function.Try;

public class EmployeeIDException extends Exception{
        EmployeeDetail ed = new EmployeeDetail();
        public EmployeeIDException(){
            if(ed.getEmployeeID() < 0) {
                System.out.println("Employee ID must be greater than or equal to 1");
            }
    }
}
