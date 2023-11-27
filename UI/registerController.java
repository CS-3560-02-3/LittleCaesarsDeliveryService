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
import java.sql.Statement;
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
import javafx.scene.control.Label;

import Model.customer;

public class registerController {

    private Stage stage;
    private Scene scene;
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";
    //static final String PASSWORD = "ilovemysql23";

    public static customer Customer;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private PasswordField confirmPasswordPasswordField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField deliveryAddressTextField;

    @FXML
    private TextField cardNumberTextField;

    @FXML
    private TextField expDateTextField;

    @FXML
    private TextField cvvTextField;

    @FXML
    private CheckBox acceptCheckBox;

    @FXML
    private Label loginMessageLabel;

    globalController GlobalController = globalController.getGlobalController();


    @FXML
    public void switchToUserLogin(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/customerLoginViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void createAccount(ActionEvent event) throws IOException{
        // Parent root = FXMLLoader.load(getClass().getResource("view/customerRegister2.fxml"));
        // stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;

        if(emailTextField.getText().isEmpty() || usernameTextField.getText().isEmpty() || passwordPasswordField.getText().isEmpty() || 
            confirmPasswordPasswordField.getText().isEmpty() || nameTextField.getText().isEmpty() || 
            deliveryAddressTextField.getText().isEmpty() || cardNumberTextField.getText().isEmpty() || 
            expDateTextField.getText().isEmpty() || cvvTextField.getText().isEmpty()) {
            
            loginMessageLabel.setText("Please complete all areas");
        }
        else if(!passwordPasswordField.getText().equals(confirmPasswordPasswordField.getText())){
            // Passwords are not the same in text box
            loginMessageLabel.setText("Passwords do not match!");
        }
        else if(!acceptCheckBox.isSelected()){
            loginMessageLabel.setText("Please Accept Terms and Conditions");
        }
        else {

            

            try {   
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

                String query = "SELECT customerID FROM customer WHERE customerID = (SELECT MAX(customerID) FROM customer)";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);

                int retrievedCustomerID = 0;
                while(resultSet.next()) {
                    retrievedCustomerID = resultSet.getInt("customerID");
                }
                int customerID = retrievedCustomerID + 1;
                String username = usernameTextField.getText();
                String password = passwordPasswordField.getText();
                String name = nameTextField.getText();
                String deliveryAddress = deliveryAddressTextField.getText();
                String emailAddress = emailTextField.getText();
                String cardNumber = cardNumberTextField.getText();
                String expDate = expDateTextField.getText();
                String cvv = cvvTextField.getText();
                preparedStatement = connection.prepareStatement("SELECT username FROM customer WHERE username = ?");
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                
                

    

                // if username is not found in database, then username is available
                if (resultSet.isBeforeFirst()) {
                    System.out.println("Username not found");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Username is already taken");
                    alert.show();
                    resultSet.close();
                }
                else {
                    customer Customer = new customer(customerID, username, password, name, deliveryAddress, emailAddress, cardNumber, expDate, cvv);
                    query = "INSERT INTO customer" +
                    "  (customerID, username, password, name, deliveryAddress, emailAddress, cardNumber, expDate, cvv) VALUES " +
                    " (?, ?, ?, ?, ?, ?, ?, ?, ?);";
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1,customerID);
                    preparedStatement.setString(2,username);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, name);
                    preparedStatement.setString(5,deliveryAddress);
                    preparedStatement.setString(6,emailAddress);
                    preparedStatement.setString(7,cardNumber);
                    preparedStatement.setString(8, expDate);
                    preparedStatement.setString(9, cvv);
                    preparedStatement.executeUpdate();

                    GlobalController.setCustomerID(customerID);

                    Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

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

        // else {

            // try 
            // {   
            //     String username = usernameTextField.getText();
            //     String password = passwordPasswordField.getText();
            //     connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            //     preparedStatement = connection.prepareStatement("SELECT username FROM customer WHERE username = ?");
            //     preparedStatement.setString(1, username);
            //     resultSet = preparedStatement.executeQuery();


            //     // if username is not found in database, then username is available
            //     if (resultSet.isBeforeFirst()) {
            //         System.out.println("Username not found");
            //         Alert alert = new Alert(Alert.AlertType.ERROR);
            //         alert.setContentText("Username is already taken");
            //         alert.show();
            //     } 
            //     else {

            //         Customer = new customer(username, password);

            //         Parent root = FXMLLoader.load(getClass().getResource("view/customerRegister2.fxml"));
            //         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            //         scene = new Scene(root);
            //         stage.setScene(scene);
            //         stage.show();
            //     }

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
                
            //     resultSet.close();
            // }
            // catch(SQLException e) {
            //     e.printStackTrace();
            // }
            // DO THE REST
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
