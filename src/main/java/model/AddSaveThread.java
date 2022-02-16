package model;

import java.io.IOException;
import java.util.ArrayList;

/*
    SaveTread implements interfaces to save the file after the user
    enters the input from the main() of the application
 */
public class AddSaveThread implements Runnable{
    EmployeeOutput employeeOutput = new EmployeeOutput();
    EmployeeAdd employeeAdd = new EmployeeAdd();
    ArrayList<EmployeeAdd> employeeList = employeeAdd.getInfo();

    // A default constructor
    public AddSaveThread() throws EmployeeIDException, IOException {
    }

    @Override
    public void run() {
        try {
            employeeOutput.saveOutput(employeeList);
        } catch (EmployeeIDException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
