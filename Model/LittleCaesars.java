package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;

public class LittleCaesars {
    static final String DB_URL = "jdbc:mysql://localhost:3306/CS3560";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";

    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); Statement statement = connection.createStatement();) {

            String filePath = "C:/Users/AwesomePiggy44/Desktop/Code/Java Code/CS 3560/Database/cs3560.sql";
            String sql = readSQLFromFile(filePath);

            String[] sqlStatements = sql.split(";");
            for (String statementText : sqlStatements) {
                statementText = statementText.trim();
                if (!statementText.isEmpty()) {
                    statement.execute(statementText);
                }
            }
            
            displayData(statement);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayData(Statement statement) throws SQLException {
        String selectQuery = "SELECT * FROM employee";
        try (ResultSet resultSet = statement.executeQuery(selectQuery)) {
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                 System.out.print(resultSet.getInt("employeeID") + "\t\t");
                    System.out.print(resultSet.getString("name") + "\t");
                    System.out.print(resultSet.getString("username") + "\t\t");
                    System.out.print(resultSet.getString("password") + "\t\t");
                    System.out.println();
            }
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
        catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

