package fileInputOutput;

import model.EmployeeAdd;

import java.io.File;
import java.sql.*;


public class DataConnection {
    String dataFilename;
    File dataFile = new File(".");
//        private Connection conn = null;
    String url = "jdbc:sqlite:" + dataFile.getAbsolutePath()
            +File.separator +"files" + File.separator + dataFilename;
    Connection conn = DriverManager.getConnection(url);

//    private Connection conn = null;
    public DataConnection(String dbfilename) throws SQLException {
        // TODO Auto-generated constructor stub
        if(this.conn == null) {
            connect(dbfilename);
        }
        else {
            System.out.println("Connection already opened");
        }
    }

    public DataConnection() throws SQLException {

    }

    private void connect(String dataFilename) throws SQLException {
        File dataFile = new File(".");
        String url = "jdbc:sqlite:" + dataFile.getAbsolutePath()
                +File.separator +"files" + File.separator + dataFilename;

        this.conn = DriverManager.getConnection(url);
        System.out.println("Connection to database successfully");
    }

    public void addEmplolyeeToDB(EmployeeAdd employeeAdd) throws SQLException {
        String query = "INSERT INTO "
                + "Employee(employeeID, fName, lName, hireDate, status)"
                + " values(? , ? , ? , ?, ?,?)";
        PreparedStatement prepared = this.conn.prepareStatement(query);

        prepared.setInt(1, employeeAdd.getEmployeeID());
        prepared.setString(2, employeeAdd.getFirstName());
        prepared.setString(3, employeeAdd.getLastName());
        prepared.setString(4, employeeAdd.getHireDate());
//        prepared.setDouble(5, employeeAdd.getSalary());
        prepared.setString(5, employeeAdd.getStatus());
        prepared.execute();

        String query2 = "INSERT INTO "
                + "Salary(employeeID,salary)"
                + " values(? , ?)";
        PreparedStatement prepared2 = this.conn.prepareStatement(query2);
        prepared.setInt(1, employeeAdd.getEmployeeID());
        prepared.setDouble(2, employeeAdd.getSalary());
        prepared.execute();
    }

    public void insertData() throws SQLException {
        String insertInfo = "INSERT INTO Employee(employeeID,fName,lName,hireDate,status)" +
                "values" +
                "(1, 'Kat', 'Burr', '01/01/2021', 'active')," +
                "(2, 'Han', 'Do', '01/01/2022', 'active')," +
                "(3, 'Adam', 'Lee', '05/15/2021', 'active')," +
                "(4, 'Jake', 'Hunt', '12/21/2001', 'inactive')," +
                "(5, 'Steve', 'Eve', '05/01/2020', 'active')," +
                "(6, 'Ayla', 'Shi', '04/01/2011', 'inactive')," +
                "(7, 'Mel', 'May', '09/01/2018', 'inactive')," +
                "(8, 'Jess', 'Gor', '07/25/2018', 'inactive'),";

        try (PreparedStatement statement = conn.prepareStatement(insertInfo)){
            statement.executeUpdate();
        }
        String insertInfo2 = "INSERT INTO Salary(employeeID,salary)" +
                "VALUES" +
                "(1, 76000.0)," +
                "(2, 65000.0)," +
                "(3, 51000.0)," +
                "(4, 75000.0)," +
                "(5, 68000.0)," +
                "(6, 34000.0)," +
                "(7, 74000.0)," +
                "(8, 66500.0),";
        try (PreparedStatement statement = conn.prepareStatement(insertInfo2)){
            statement.executeUpdate();
        }
    }

    public void displayStatusOrder(String orderInput) throws SQLException {

        String query = "SELECT employeeID, fName, lName, hireDate, salary, status"
                + "FROM Employee " +
                "FULL JOIN Salary" +
                "ON Employee.employeeID = Salary.employeeID"
                + orderInput;
        if (orderInput == "status")
            query += "ORDER BY status ASC";

        PreparedStatement prepared = this.conn.prepareStatement(query);

        ResultSet rs = prepared.executeQuery();
        ResultSetMetaData resultMeta = rs.getMetaData();

        System.out.println("\n**********************************");
        //Display columns
        System.out.print("*");
        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
            System.out.print("\t"
                    + resultMeta.getColumnName(i).toUpperCase()
                    + "\t *");

        System.out.println("\n**********************************");

        while(rs.next()) {
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t"
                        + rs.getObject(i).toString()
                        + "\t |");

            System.out.println("\n---------------------------------");
        }

        rs.close();
        prepared.close();

    }

    public void displayJoin() throws SQLException {
        displayAggregate();
        String query = "SELECT employeeID, fName, lName, hireDate, salary, status"
                + "FROM Employee " +
                "FULL JOIN Salary" +
                "ON Employee.employeeID = Salary.employeeID"+
                "ORDER BY fName, lName";

        PreparedStatement prepared = this.conn.prepareStatement(query);

        ResultSet rs = prepared.executeQuery();
        ResultSetMetaData resultMeta = rs.getMetaData();

        System.out.println("\n**********************************");
        //Display columns
        System.out.print("*");
        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
            System.out.print("\t"
                    + resultMeta.getColumnName(i).toUpperCase()
                    + "\t *");

        System.out.println("\n**********************************");

        while(rs.next()) {
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t"
                        + rs.getObject(i).toString()
                        + "\t |");

            System.out.println("\n---------------------------------");
        }
        rs.close();
        prepared.close();

    }

    // displayAggregate method display the statistic salary data
    public void displayAggregate() throws SQLException {
        String query = "SELECT COUNT(employeeID) AS totalEmployee, min(salary) as minimumSalary," +
                "max(salary), avg(salary)\n" +
                "FROM salary";
        PreparedStatement prepared = this.conn.prepareStatement(query);
        ResultSet rs = prepared.executeQuery();
        rs.close();
        prepared.close();
    }

        /**
         * Close the connection to avoid any
         * problems (database lock)
         */
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
