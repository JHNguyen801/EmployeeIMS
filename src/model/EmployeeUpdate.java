package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/*
    EmployeeUpdate class is reading the data and update the employee
    information. It is not yet implement.
 */
public class EmployeeUpdate
{
    ArrayList<EmployeeAdd> employeeList = new ArrayList<>();
    EmployeeShow employeeShow = new EmployeeShow();
    EmployeeAdd ed = new EmployeeAdd();

    public static ArrayList<EmployeeAdd> loadData() {
        ArrayList<EmployeeAdd> employeeList = new ArrayList<>();
        EmployeeAdd employeeAdd = new EmployeeAdd();
        FileInputStream fstream = null;
        try {
            File file = new File("src/data/employee.csv");
            fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strline = "";
            String[] token = strline.split(",");

            // read file line by line
            while ((strline = br.readLine()) != null) {
                token = strline.split(",");

                employeeAdd = new EmployeeAdd(Integer.parseInt(token[0]), token[1], token[2],
                        token[3], Double.parseDouble(token[4]), token[5]);
                employeeList.add(employeeAdd);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EmployeeIDException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public double updateEmployee(int id){
        Scanner sc = new Scanner(System.in);
        loadData();
        double sortSalary = 0;
        for(int i = 0; i < employeeList.size(); i++){
            if(id == ed.getEmployeeID()){
                System.out.println("Please enter a new salary");
                sortSalary = sc.nextDouble();
                ed.setSalary(sortSalary);
            }
        }
        return sortSalary;
    }
}
