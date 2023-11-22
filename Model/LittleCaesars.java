package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DButil;

import java.io.BufferedReader;
import java.io.FileReader;

public class LittleCaesars {
    static final String DB_URL = "jdbc:mysql://localhost:3306/CS3560";
    static final String USER = "root";
    //change the password so you can view it. It is the password for your SQL login
    static final String PASSWORD = "ilovemysql23";
    private static final String DB_DRIVER = 
		           "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) throws Exception {
        // try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); Statement statement = connection.createStatement();) {
        //     //change the file path name to the sql file location in order to run it
        //     String filePath = "C:/Users/Cesar de Paula/Desktop/Class Files/Fall 2023/CS3560/GroupProject/LittleCaesarsDeliveryService/Database/cs3560.sql";
        //     String sql = readSQLFromFile(filePath);

        //     String[] sqlStatements = sql.split(";");
        //     for (String statementText : sqlStatements) {
        //         statementText = statementText.trim();
        //         if (!statementText.isEmpty()) {
        //             statement.execute(statementText);
        //         }
        //     }
            
        //     displayData(statement);
        // }
        // catch (SQLException e) {
        //     e.printStackTrace();
        // }

        System.out.println("Connecting to a selected database...");


        // Open a connection
        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT vehiclePlateNumber FROM driver WHERE username = ?");
        )
        {		      
            preparedStatement.setString(1, "nickamancio");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String retrievedPassword = resultSet.getString("vehiclePlateNumber");
                System.out.println(retrievedPassword);

            }   
            resultSet.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        // Connection conn = null;
		// try{
		// 	//Register the JDBC driver
		// 	Class.forName(DB_DRIVER);
 
		// 	//Open the connection
		// 	conn = DriverManager.
		// 	getConnection(DB_URL, USER, PASSWORD);
 
		// 	if(conn != null){
		// 	   System.out.println("Successfully connected.");
		// 	}else{
		// 	   System.out.println("Failed to connect.");
		// 	}
		// }catch(Exception e){
		// 	e.printStackTrace();
		// }

    }

    private static void displayData(Statement statement) throws SQLException {
        String selectQuery = "SELECT * FROM delivery";
        try (ResultSet resultSet = statement.executeQuery(selectQuery)) {
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                 System.out.print(resultSet.getInt("deliveryID") + "\t\t");
                    System.out.print(resultSet.getString("estimatedTime") + "\t");
                    System.out.print(resultSet.getString("deliveryStatus") + "\t\t");
                    System.out.print(resultSet.getString("deliveryDate") + "\t\t");
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

