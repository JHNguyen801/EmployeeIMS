package data;

import model.EmployeeOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TextHandling {
    private ArrayList<EmployeeOutput> listOfEmployee = new ArrayList<>();

    public TextHandling() {
    }

    public ArrayList<EmployeeOutput> getListOfEmployee() {
        return listOfEmployee;
    }

    public void setListOfEmployee(ArrayList<EmployeeOutput> listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    private String filename = "src/data" + File.separator + "employee.txt";
    /**
     * Writes out text file
     */
    public void writeTextFile() {
        PrintWriter pw = null;
        try{
            Scanner infile = new Scanner(new File(filename));
            int id;
            String firstName, lastName, hireDate, status;
            while (infile.hasNext()){
                id = infile.nextInt();
                firstName = infile.next();
                lastName = infile.next();
                hireDate = infile.next();
                status = infile.next();
            }
//            "Employee ID: " + emp.getEmployeeId() + "\t" +
//                        "First Name: " + emp.getFirstName() + "\t" +
//                        "Last Name: " + emp.getLastName() + "\t" +
//                        "Hired Date: " + emp.getHireDate() + "\t" +
//                        "Status: " + emp.getStatus());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            pw = new PrintWriter("src/employee.txt");
//
//            // Loop through the array list of classrooms and print comma delimited to a text file
//            for (EmployeeAdd employee : listOfEmployee) {
//                pw.println(employee.toString());
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            // Flush the output stream and close the file
//            pw.flush();
//            pw.close();
//        }
    }

    /**
     * Read a delimited text file, the delimeter is ":". You need to know the
     * format of the text file in order to parse it correctly. The format of the
     * text file is:
     */
    public void readTextFile() {
//        String filename = "data/employee.txt";
//        try{
//            Scanner readFile = new Scanner(new File(filename));
//            while(readFile.hasNext()){
//                System.out.println(readFile);
//            }
//        }
//        catch (FileNotFoundException e){
//            System.out.println("File not found");
//        }
//        try {
//            // Declare and instantiate the file to read from
//            FileReader fr = new FileReader(filename);
//            BufferedReader reader = new BufferedReader(fr);
//
//            // Create a storage variable to store the strings in as they are read
//            String lineFromFile = new StringBuffer();
//            // Read in first line of file
//            lineFromFile = reader.readLine();
//            // read remainder of file, the contents of buffer get overwritten with each call
//            while (lineFromFile != null) {
//                lineFromFile = reader.readLine();
//                System.out.println(lineFromFile);
//            }
//            reader.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            File file = new File("data/employee.text");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
            {
                System.out.println(sc.nextLine());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
