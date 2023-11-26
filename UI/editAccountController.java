package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import Model.customer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class editAccountController implements Initializable {
    
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField deliveryAddressTextField;
    @FXML
    private TextField cardNumberTextField;
    @FXML
    private TextField expDateTextField;
    @FXML
    private TextField cvvTextField;
    @FXML
    private Button backButton;
    @FXML
    private Button saveButton;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("Switched to Edit Account");


        
    }





}
