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
import javafx.scene.control.Label;

public class registerController {

    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private PasswordField confirmPasswordPasswordField;

    @FXML
    private Label loginMessageLabel;

    public void register(ActionEvent event) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if(usernameTextField.getText().isEmpty() && 
            passwordPasswordField.getText().isEmpty() && 
            confirmPasswordPasswordField.getText().isEmpty()) {

            loginMessageLabel.setText("Please enter username and password");
        }
        else if(!passwordPasswordField.getText().equals(confirmPasswordPasswordField.getText())){
            // Passwords are not the same text box
        }
        else {
            // DO THE REST
        }
    }

}
