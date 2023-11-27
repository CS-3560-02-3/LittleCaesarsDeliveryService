package UI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;


public class employeeOrderController {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private Label loginMessageLabel;

    public void signOut(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("view/mainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEmployeeOrderScene(ActionEvent event) throws IOException {

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
        else 
        {

            try 
            {   
                // retrieving information from user
                String username = usernameTextField.getText();
                String password = passwordPasswordField.getText();

                // connecting to database
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

                // retrieving password associated to username from database
                preparedStatement = connection.prepareStatement("SELECT password FROM driver WHERE username = ?");
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();

                // if resultSet is empty, then username does not exist
                if (!resultSet.isBeforeFirst()) {
                    System.out.println("Username not found");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Incorrect Credentials");
                    alert.show();
                }   

                // if resultSet is not empty, then username does exist
                while (resultSet.next()) {


                    String retrievedPassword = resultSet.getString("password");
                    System.out.println(retrievedPassword);

                    // compare password from user to password from database
                    if(retrievedPassword.equals(password)) {

                        // changeScene
                        Parent root = FXMLLoader.load(getClass().getResource("view/employeeOrderViewUI.fxml"));
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
