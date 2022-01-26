package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
    EmployeeShow class read a CSV file that store data in the arrayList.
    It displays the data information from a CSV file.
 */
public class EmployeeShow {
//    ArrayList<EmployeeDetail> employeeList = new ArrayList<>();
//    static EmployeeDetail ed = new EmployeeDetail();
//    public  void viewFile(String s){
//        File file = new File("src/data/employee.csv");
//        try {
//            Scanner sc = new Scanner(file);
//            while (sc.hasNextLine()) {
//                System.out.println(sc.nextLine());
//            }
//        }
//        catch (FileNotFoundException nf){
//            System.out.println("File not found");
//        }
//    }

    // readDataFromFile method read the csv file and display info on the screen
    public static void readDataFromFile(){
        ArrayList<EmployeeDetail> employeeList = new ArrayList<>();
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
                employeeList.add(new EmployeeDetail(Integer.parseInt(token[0]), token[1], token[2],
                        token[3], token[4]));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (NumberFormatException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
        }
        // loop the employee list and display the output from the csv file
        for(int i = 0; i < employeeList.size(); i++){
            System.out.println("EmployeeID: " + employeeList.get(i).getEmployeeID());
            System.out.println("First Name: " + employeeList.get(i).getFirstName());
            System.out.println("Last Name: " + employeeList.get(i).getLastName());
            System.out.println("Hire Date: " + employeeList.get(i).getHireDate());
            System.out.println("Status: " + employeeList.get(i).getStatus() + "\n");
        }
    }
}
