package model;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeOutputTest {

    @Test
    void saveOutput() throws IOException {
        File filename = new File("src/data/employeetest.csv");
        FileWriter fw = new FileWriter(filename, true);
        PrintWriter myWriter = new PrintWriter(fw);
    }
}