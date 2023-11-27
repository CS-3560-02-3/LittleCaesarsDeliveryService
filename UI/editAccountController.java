package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Model.customer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class editAccountController {

    //JDBC connection
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";
    //static final String PASSWORD = "ilovemysql23";

    private Stage stage;
    private Scene scene;
    
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
    private Label saveChangesLabel;
    @FXML
    private Button backButton;
    @FXML
    private Button saveButton;

    private String initNameString;
    private String initDeliveryAddressString;
    private String initCardNumberString;
    private String initExpDateString;
    private String initCVVString;

    globalController GlobalController = globalController.getGlobalController();
    customer currentCustomer;


    public void initialize() {

        System.out.println("Switched to Edit Account");

        // retrieve customer ID of current customer logged in
        int currentCustomerID = GlobalController.getCustomerID();
        System.out.println("Current Customer ID: " + currentCustomerID);

        currentCustomer = new customer(currentCustomerID);

        // setting initial information
        initNameString = currentCustomer.getName();
        nameTextField.setText(initNameString);

        initDeliveryAddressString = currentCustomer.getDeliveryAddress();
        deliveryAddressTextField.setText(initDeliveryAddressString);

        initCardNumberString = currentCustomer.getCardNumber();
        cardNumberTextField.setText(initCardNumberString);

        initExpDateString = currentCustomer.getCardCVV();
        expDateTextField.setText(initExpDateString);

        initCVVString = currentCustomer.getCardCVV();
        cvvTextField.setText(initCVVString);
    }

    // preconditions:
    // all fields must be filled out
    public void saveChanges(ActionEvent event) throws IOException {

        // retrieve currently logged in customer by ID
        int currentCustomerID = GlobalController.getCustomerID();

        // JDBC
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        // retrieve input from UI
        String nameString = nameTextField.getText();
        String deliveryAddressString = deliveryAddressTextField.getText();
        String cardNumberString = cardNumberTextField.getText();
        String expDateString = expDateTextField.getText();
        String cvvString = cvvTextField.getText();

        // check if all fields are filled out
        if(nameString.isEmpty() || deliveryAddressString.isEmpty() || 
        cardNumberString.isEmpty() || expDateString.isEmpty() || cvvString.isEmpty()) {
            saveChangesLabel.setText("Please fill out all fields");
        }
        // check if any changes have been made
        else if(initNameString.equals(nameString) && initDeliveryAddressString.equals(deliveryAddressString) && 
        initCardNumberString.equals(cardNumberString) && initExpDateString.equals(expDateString) && initCVVString.equals(cvvString)){
            Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        // update changes in database
        else {

            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                String query = "UPDATE customer SET name = ?, deliveryAddress = ?, cardNumber = ?, expDate = ?, cvv = ? WHERE customerID = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, nameString);
                preparedStatement.setString(2, deliveryAddressString);
                preparedStatement.setString(3, cardNumberString);
                preparedStatement.setString(4, expDateString);
                preparedStatement.setString(5, cvvString);
                preparedStatement.setInt(6, currentCustomerID);
                preparedStatement.executeUpdate();

                Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
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
    }

    // method to return to menu page
    public void switchToMenu(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
