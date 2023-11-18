package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;

public class LittleCaesars {
    static final String DB_URL = "jdbc:mysql://localhost:3306/cs3560";
    static final String USER = "root";
    static final String PASSWORD = "diamondbar13";

    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); Statement statement = connection.createStatement();) {
            String filePath = "Database/cs3560.sql";
            String sql = readSQLFromFile(filePath);
            
            statement.executeUpdate(sql);
            System.out.println("SQL statements executed successfully");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String readSQLFromFile(String filePath) throws Exception {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}

