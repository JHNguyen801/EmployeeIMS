package view;

import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Class EmployeeMSDemo contains the main method that instantiate the class object.
    It calls the displayEmployeeInfo method to print the information stores in the
    class constructor.
 */
public class EmployeeApp {
    public static void main(String[] args) throws IOException, EmployeeIDException, EmployeeIDException {
        EmployeeShow es = new EmployeeShow();
        EmployeeDetail staff = new EmployeeDetail();
        Scanner select = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        char userInput;

        mainMenu();
        boolean valid = false;

        /*** Initializing loop for Menu Choices ***/
        while (!valid) {
            try {
                System.out.print("\nPlease Enter a number: ");
                userInput = select.nextLine().charAt(0);
            }
            catch(StringIndexOutOfBoundsException e){
                System.out.print("\nPlease enter an input number: ");
                userInput = select.nextLine().charAt(0);
            }

            /** Switch Case Statements **/
            switch (userInput) {
                case '1': {
                    /** Creating class's object and calling Function using that object **/
                    EmployeeOutput se = new EmployeeOutput();
//                    EmployeeDetail ed = new EmployeeDetail();
                    List<EmployeeDetail> employeeList = staff.getInfo();
                    se.saveOutput(employeeList);
                    mainMenu();
                    break;
                }
                case '2': {
                    es.readDataFromFile();
                    System.out.println("\nPress Enter to Continue...");
                    mainMenu();
                    break;
                }
                case '3': {
                    EmployeeUpdate update = new EmployeeUpdate();
                    System.out.println("Please Enter Employee's ID :");
                    int I = select.nextInt();
                    try {
                        update.updateEmployee(I);
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
//
                    System.out.print("\nPlease Enter the detail you want to Update :");
                    update.updateEmployee(I);
                    System.out.println("\nPress Enter to Continue...");
                    mainMenu();
                    break;
                }
                case '4':{
//                    es.readDataFromFile();
                    int rank = 1;
                    ArrayList<EmployeeDetail> employeeList = staff.getEmployeeDetails();
                    Ranking.rank(employeeList);

                    System.out.println("\n\t\t\tEMPLOYEE LIST");
                    System.out.println("*******************************************");
                    System.out.printf("%5s %15s %15s %15s %10s %12s","EmployeeID: ",
                            "First Name: ", "Last Name: ", "Hire Date: ",
                            "Salary", "Status:");
                    for(int i = 0; i < employeeList.size(); i++){
                        System.out.println();
                        System.out.format("%5s %15s %20s %15s %12s %12s",
                                employeeList.get(i).getEmployeeID(), employeeList.get(i).getFirstName(),
                                employeeList.get(i).getLastName(), employeeList.get(i).getHireDate(),
                                employeeList.get(i).getSalary(), employeeList.get(i).getStatus());
                        rank++;
                    }
                    System.out.print("\nPress Enter to Continue...");
                    mainMenu();
                    break;
                }
                case '5': {
                    System.out.println("\n*****************************************");
                    System.out.println("\t Program terminated ");
                    System.exit(0);
                }
                mainMenu();
                default:
                    System.out.println("Wrong input, it must be a number");
            }
        }
    }

    private static void mainMenu() {
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t  Employee Information Management System");
        System.out.println("\t\t*******************************************");
        System.out.println("Enter 1 : To Add an Employee Details ");
        System.out.println("Enter 2 : To See an Employee Details ");
        System.out.println("Enter 3 : To Update Employee Details ");
        System.out.println("Enter 4 : To Sort Employee by Salary ");
        System.out.println("Enter 5 : To Exit the EIMS Portal ");
    }
}
