package bank.managment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
     Statement s;
     Connection cn;

    public Conn() {
        try {
            String url = "jdbc:mysql://localhost:3306/BankManagmentSystem"; // Replace with your actual database name
            String username = "root"; // Replace with your database username
            String password = "Saurabh@9583"; // Replace with your database password

            // Establish connection
            cn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successfully established.");

            // Create statement
            s = cn.createStatement();
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
