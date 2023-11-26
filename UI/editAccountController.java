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
import Model.customer;

public class editAccountController {

    private Stage stage;
    private Scene scene;
    
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

    private int customerID;

    // public void initialize(URL url, ResourceBundle resourceBundle) {

    //     System.out.println("Switched to Edit Account");


    //     // System.out.println(customerID);
        
    // }

    // public void initialize() {
    //     System.out.println(customerID);
    // }



    public void switchToMenu(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
        System.out.println(customerID);
        System.out.println("Switched to Edit Account");
        // customer Customer = new customer(customerID);

    }

    public int getCustomerID() {
        return this.customerID;
    }





}
