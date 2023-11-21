package Database;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    private Stage stage;
    private Scene scene;

    public void changeScene(ActionEvent event, String FXMLpath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(FXMLpath));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        catch (Exception e) {
            e.printStackTrace();
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
