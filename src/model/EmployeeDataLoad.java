package model;

import view.EmployeeApp;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/*
    EmployeeDataLoad class is reading the data from a CSV file and store
    data into an ArrayList.
 */
public class EmployeeDataLoad
{
    // Load method is to read CSV file and store data in the ArrayList when
    // the program is launch
    public static ArrayList<EmployeeAdd> loadData(ArrayList<EmployeeAdd> employeeList) {
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


}
