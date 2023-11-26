package UI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import UI.globalController;

public class customerController {
    private Stage stage;
    private Scene scene;
    private static boolean loggedIn;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button createAccountButton;

    @FXML
    private Label loginMessageLabel;

    public static customer Customer;

    // public int customerID;

    globalController GlobalController = globalController.getGlobalController();


    @FXML
    private void switchToUserLogin(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/customerLoginViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCreateCustomerAccount(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/customerRegister.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCreateCustomerAccount2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("view/customerRegister2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCustomerMainMenu(ActionEvent event) throws IOException{

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

                // Open a connection
            try 
            {   
                String username = usernameTextField.getText();
                String password = passwordPasswordField.getText();
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                preparedStatement = connection.prepareStatement("SELECT password FROM customer WHERE username = ?");
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();

                if(!resultSet.isBeforeFirst()) {
                    System.out.println("Username not found");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Incorrect Credentials");
                    alert.show();
                }   

                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    System.out.println(password);
                    System.out.println(retrievedPassword);

                    if(retrievedPassword.equals(password)) {

                        setLoggedInStatus(true);

                        preparedStatement = connection.prepareStatement("SELECT customerID FROM customer WHERE username = ?");
                        preparedStatement.setString(1, username);
                        
                        ResultSet rs = preparedStatement.executeQuery();
                        int customerID = 0;

                        if(rs.next()) {
                            customerID = rs.getInt("customerID");
                        }

                        System.out.println(customerID);

                        // Customer = new customer(customerID);

                        
                        
                        // globalController.setCustomer(Customer);

                        // customer testCustomer = globalController.getCustomer();
                        // String testCVV = testCustomer.getCardCVV();
                        // System.out.println(testCVV);
                        
                        // changeScene
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/menu.fxml"));
                        Parent root = loader.load();

                        // menuController MenuController = loader.getController();
                        // MenuController.setCustomerID(customerID);

                        GlobalController.setCustomerID(customerID);

                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        // GlobalController.changeLoggedIn(true);
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

    public void setLoggedInStatus(boolean status) {
        customerController.loggedIn = status;
    }

    public boolean getLoggedInStatus() {
        return loggedIn;
    }

    

    public void switchToCustomerMainMenuAfterCreateAccount(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
