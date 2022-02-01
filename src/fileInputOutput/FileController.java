package fileInputOutput;

import model.EmployeeAdd;
import model.EmployeeIDException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileController {
    private static String filePath = "data" + File.separator+"employee.csv";

    public static ArrayList<EmployeeAdd> loadData(ArrayList<EmployeeAdd> employeeList) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(filePath));
        int employeeID = 0;
        String firstName = "", lastName = "", hireDate ="", status = "";
        double salary = 0.0;

        while (inFile.hasNext()){
            employeeID = inFile.nextInt();
            firstName = inFile.next();
            lastName = inFile.next();
            hireDate = inFile.next();
            salary = inFile.nextDouble();
            status = inFile.next();
        }
        EmployeeAdd employeeAdd = null;
        try{
            employeeAdd = new EmployeeAdd(employeeID, firstName, lastName, hireDate, salary, status);
        } catch (EmployeeIDException e) {
            e.printStackTrace();
        }

        inFile.close();
        System.out.println("Data loaded sucessfully!");

//        FileInputStream fstream = null;
//        try {
//            File file = new File("src/data/employee.csv");
//            fstream = new FileInputStream(file);
//            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
//            String strline = "";
//            String[] token = strline.split(",");
//
//            // read file line by line
//            while ((strline = br.readLine()) != null) {
//                token = strline.split(",");
//
//                employeeAdd = new EmployeeAdd(Integer.parseInt(token[0]), token[1], token[2],
//                        token[3], Double.parseDouble(token[4]), token[5]);
//                employeeList.add(employeeAdd);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        } catch (NumberFormatException e) {
//            System.out.println(e);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (EmployeeIDException e) {
//            e.printStackTrace();
//        }
        return employeeList;
    }
}
