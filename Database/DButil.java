package Database;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DButil {
    static final String DB_URL = "jdbc:mysql://localhost:3306/CS3560";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";

    private static Stage stage;
    private static Scene scene;

    // public static void changeScene(ActionEvent event, String FXMLpath) {
    //     try {
    //         Parent root = FXMLLoader.load(getClass().getResource(FXMLpath));
    //         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    //         scene = new Scene(root);
    //         stage.setScene(scene);
    //         stage.show();

    //     }
    //     catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    public static void employeeLogIn(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/CS3560";
        final String USER = "root";
        //change the password so you can view it. It is the password for your SQL login
        final String PASSWORD = "ilovemysql23";

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT password FROM driver WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Username not found");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect Credentials");
                alert.show();
            }
            else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString(password);
                    
                    if(retrievedPassword.equals(password)) {
                        // changeScene
                    }
                }
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

    public static void customerSignUp(ActionEvent event, String username, String password, String name, String address, int cardNumber, int cardDate, int cardCVV) {

    }

    public static void addItemToOrder(ActionEvent event, int itemID, String name, double itemPrice) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement addItem = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); 
            addItem = connection.prepareStatement("SELECT * FROM item");
            resultSet = addItem.executeQuery();
            System.out.println(resultSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (addItem != null) {
                try {
                    addItem.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
