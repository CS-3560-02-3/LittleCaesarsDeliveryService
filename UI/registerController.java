package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import Model.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import Model.customer;
import UI.register2Controller;

public class registerController {

    private Stage stage;
    private Scene scene;
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";

    public static customer Customer;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private PasswordField confirmPasswordPasswordField;

    @FXML
    private CheckBox acceptCheckBox;

    @FXML
    private Label loginMessageLabel;


    @FXML
    public void switchToUserLogin(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/customerLoginViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCreateCustomerAccount2(ActionEvent event) throws IOException{
        // Parent root = FXMLLoader.load(getClass().getResource("view/customerRegister2.fxml"));
        // stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if(usernameTextField.getText().isEmpty() && 
            passwordPasswordField.getText().isEmpty() && 
            confirmPasswordPasswordField.getText().isEmpty()) {

            loginMessageLabel.setText("Please enter username and password");
        }
        else if(!passwordPasswordField.getText().equals(confirmPasswordPasswordField.getText())){
            // Passwords are not the same in text box
        }
        else {

            try 
            {   
                String username = usernameTextField.getText();
                String password = passwordPasswordField.getText();
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                preparedStatement = connection.prepareStatement("SELECT username FROM customer WHERE username = ?");
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();


                // if username is not found in database, then username is available
                if (resultSet.isBeforeFirst()) {
                    System.out.println("Username not found");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Username is already taken");
                    alert.show();
                } 
                else {

                    Customer = new customer(username, password);

                    Parent root = FXMLLoader.load(getClass().getResource("view/customerRegister2.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

                // while (resultSet.next()) {
                //     String retrievedPassword = resultSet.getString("password");
                //     System.out.println(retrievedPassword);

                //     // if(retrievedPassword.equals(password)) {
                //     //     // changeScene
                //     //     Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
                //     //     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                //     //     scene = new Scene(root);
                //     //     stage.setScene(scene);
                //     //     stage.show();
                //     // }

                // }  
                
                resultSet.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
            // DO THE REST
        }

    }

    public customer getCustomer() {
        return registerController.Customer;
    }


    // switch to register account 2
    // public void register(ActionEvent event) {

    //     Connection connection = null;
    //     PreparedStatement preparedStatement = null;
    //     ResultSet resultSet = null;

    //     if(usernameTextField.getText().isEmpty() && 
    //         passwordPasswordField.getText().isEmpty() && 
    //         confirmPasswordPasswordField.getText().isEmpty()) {

    //         loginMessageLabel.setText("Please enter username and password");
    //     }
    //     else if(!passwordPasswordField.getText().equals(confirmPasswordPasswordField.getText())){
    //         // Passwords are not the same in text box
    //     }
    //     else {

    //         try 
    //         {   
    //             String username = usernameTextField.getText();
    //             String password = passwordPasswordField.getText();
    //             connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
    //             preparedStatement = connection.prepareStatement("SELECT username FROM customer WHERE username = ?");
    //             preparedStatement.setString(1, username);
    //             resultSet = preparedStatement.executeQuery();


    //             // if username is not found in database, then username is available
    //             if (resultSet.isBeforeFirst()) {
    //                 System.out.println("Username not found");
    //                 Alert alert = new Alert(Alert.AlertType.ERROR);
    //                 alert.setContentText("Username is already taken");
    //                 alert.show();
    //             } 
    //             else {
                    
    //             }

    //             while (resultSet.next()) {
    //                 String retrievedPassword = resultSet.getString("password");
    //                 System.out.println(retrievedPassword);

    //                 // if(retrievedPassword.equals(password)) {
    //                 //     // changeScene
    //                 //     Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
    //                 //     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    //                 //     scene = new Scene(root);
    //                 //     stage.setScene(scene);
    //                 //     stage.show();
    //                 // }

    //             }  
                
    //             resultSet.close();
    //         }
    //         catch(SQLException e) {
    //             e.printStackTrace();
    //         }
    //         // DO THE REST
    //     }
    // }

}
