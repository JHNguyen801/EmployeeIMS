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

    /*
    This method save the current object EmployeeAdd in a file using serialization
 */
    public static void serializeEmployee(String filePath, EmployeeAdd employeeAdd) throws
            FileNotFoundException, IOException
    {
        filePath = "src/data/employee.dat";
        File serialize = new File(filePath);
        ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream(serialize));
        outfile.writeObject(employeeAdd);
        outfile.close();
        System.out.println("File successfully saved using Serialization");
    }

    /*
    This method read the current object EmployeeAdd in a file using serialization
    */
    public static EmployeeAdd deserializeEmployee(String filePath) throws FileNotFoundException,
            IOException, ClassNotFoundException {
        filePath = "src/data/employee.dat";
        File serialize = new File(filePath);
        ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(serialize));
        EmployeeAdd employeeAdd = (EmployeeAdd) inFile.readObject();
        inFile.close();
        System.out.println("File successfully loaded using Serialization");
        return employeeAdd;
    }

}
