package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LittleCaesars {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); Statement statement = connection.createStatement();) {
            String dbName = "newDataBase";
            String sql = "CREATE DATABASE " + dbName;
            statement.executeUpdate(sql);
            System.out.println("Database created Successfully");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

