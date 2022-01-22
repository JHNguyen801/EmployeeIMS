package View;

import Model.EmployeeShow;
import Model.EmployeeDetail;
import Model.EmployeeAdd;
import Model.EmployeeUpdate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
    Class EmployeeMSDemo contains the main method that instantiate the class object.
    It calls the displayEmployeeInfo method to print the information stores in the
    class constructor.
 */
public class EmployeeMSDemo {
    public static void main(String[] args) {
        EmployeeShow es = new EmployeeShow();
        Scanner select = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int i = 0;

        mainMenu();
        boolean valid = false;

        /*** Initializing loop for Menu Choices ***/
        while (!valid) {
//            if(!select.hasNextInt()){
//                System.out.print("\nPlease Enter choice: ");
//                i = select.nextInt();
//            }
            try {
                System.out.print("\nPlease Enter choice: ");
                i = select.nextInt();
            }
            catch (Exception e){
                System.out.print("\nPlease Enter choice: ");
                i = select.nextInt();
            }
            /** Switch Case Statements **/
            switch (i) {
                case 1: {
                    /** Creating class's object and calling Function using that object **/
                    EmployeeAdd se = new EmployeeAdd();
                    se.addEmployee();
                    mainMenu();
                    break;
                }
                case 2: {
                    System.out.print("\nPlease Enter Employee's ID: ");
                    String s = select.nextLine();
                    try {
                        es.viewFile(s);
                        es.displayEmployeeInfo(s);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    System.out.print("\nPress Enter to Continue...");
                    select.nextLine();
                    mainMenu();
                    break;
                }

                case 3: {
                    EmployeeDetail view = new EmployeeDetail();
                    view.getInfo();
                    System.out.print("\nPress Enter to Continue...");
                    select.nextLine();
                    mainMenu();
                    break;
                }
                case 4: {
                    System.out.print("\nPlease Enter Employee's ID :");
                    String I = select.nextLine();
                    try {
                        es.viewFile(I);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    EmployeeUpdate update = new EmployeeUpdate();
                    System.out.print("Please Enter the detail you want to Update :");
                    System.out.print("\nFor Example :\n");
                    System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. "
                            + "Then write the new Name then Press Enter. It will Update the Name.\n");
                    String s = select.nextLine();
                    System.out.print("Please Enter the Updated Info :");
                    String n = select.nextLine();
                    try {
                        update.updateFile(I, s, n);

                        System.out.print("\nPress Enter to Continue...");
                        select.nextLine();
                        mainMenu();
                        break;
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
                case 5: {
                    System.exit(0);
                }
                mainMenu();
//                displayEmployeeInfo(emp);
            }
        }
    }

    private static void mainMenu() {
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t  Employee Information Management System");
        System.out.println("\t\t*******************************************");
        System.out.println("Press 1 : To Add an Employee Details ");
        System.out.println("Press 2 : To See an Employee Details ");
        System.out.println("Press 3 : To Update Employee Details ");
        System.out.println("Press 4 : To Search an Employee ");
        System.out.println("Press 5 : To Exit the EIMS Portal ");
    }
        /*
        Display method shows the list of salaried and hourly employees
     */
//    private static void displayEmployeeInfo(Employee[] emp) {
//        System.out.println("=========Employee Information Sample==========");
//        for (Employee elem : emp) {
//            if (elem instanceof SalariedEmployee) {
//                ((SalariedEmployee)elem).display();
//                System.out.println();
//            } else if (elem instanceof HourlyEmployee) {
//                ((HourlyEmployee) elem).display();
//            }
//        }
//    }
}
