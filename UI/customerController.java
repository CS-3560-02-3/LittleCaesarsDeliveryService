package UI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class customerController {
    private Stage stage;
    private Scene scene;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button createAccountButton;

    @FXML
    private Label loginMessageLabel;

    public static customer Customer;

    globalController GlobalController = globalController.getGlobalController();

    // method to switch to register page
    public void switchToCreateCustomerAccount(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/customerRegister.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method to log in
    public void switchToCustomerMainMenu(ActionEvent event) throws IOException{

        // JDBC variables
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
        String USER = "root";
        //change the password so you can view it. It is the password for your SQL login
        // String PASSWORD = "littleCaesars";
        String PASSWORD = "ilovemysql23";
        
        if(usernameTextField.getText().isEmpty() && passwordPasswordField.getText().isEmpty()) {
            loginMessageLabel.setText("Please enter username and password");
        }
        else {

            try 
            {   
                // retrieving user input
                String username = usernameTextField.getText();
                String password = passwordPasswordField.getText();

                // opening connection to database
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

                // retrieving password associated to username from database
                preparedStatement = connection.prepareStatement("SELECT password FROM customer WHERE username = ?");
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();

                // if resultSet is empty, then username does not exist
                if(!resultSet.isBeforeFirst()) {
                    System.out.println("Username not found");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Incorrect Credentials");
                    alert.show();
                }   

                // if resultSet is not empty, then username does exist
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    System.out.println(password);
                    System.out.println(retrievedPassword);

                    // compare password from user to password in database
                    if(retrievedPassword.equals(password)) {

                        // retrieve customerID from username
                        preparedStatement = connection.prepareStatement("SELECT customerID FROM customer WHERE username = ?");
                        preparedStatement.setString(1, username);
                        ResultSet rs = preparedStatement.executeQuery();
                        int customerID = 0;

                        if(rs.next()) {
                            customerID = rs.getInt("customerID");
                        }

                        // set customerID in global controller to indicate who is logged in
                        GlobalController.setCustomerID(customerID);
                        System.out.println("this is " + GlobalController.getCustomerID());
                        
                        // changeScene
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/menu.fxml"));
                        Parent root = loader.load();

                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }

                }  
                resultSet.close();
            }
            catch (SQLException e) {
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
    }
}
