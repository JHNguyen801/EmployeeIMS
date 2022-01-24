package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeUpdate
{
    public void updateFile(String s,String o,String n) throws IOException
    {
        File file = new File("src/data/employee.text");
        Scanner sc = new Scanner(file);
        String fileContext = "";
        while (sc.hasNextLine())
        {
            fileContext = fileContext + "\n" + sc.nextLine();
        }
        FileWriter myWriter = new FileWriter("src/data/employee" + s +".txt");
        fileContext = fileContext.replaceAll(o,n);
        myWriter.write(fileContext);
        myWriter.close();

    }
}
