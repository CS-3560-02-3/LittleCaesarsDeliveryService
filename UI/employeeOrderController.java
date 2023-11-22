package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Database.DButil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;


public class employeeOrderController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Button loginButton;
    private TextField usernameField;
    private TextField passwordField;
    private Button returnToMainMenu;


    public void initialize(URL locatation, ResourceBundle resources) {

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                DButil.employeeLogIn(event, usernameField.getText(), passwordField.getText());
            }
        }

        );

        // returnToMainMenu.setOnAction(new EventHandler<ActionEvent>() {

        //     public void handle(ActionEvent event) {
        //         DButil.changeScene(event, "mainMenu.fxml");
        //     }
        // }

        // );

    }

    public void switchToEmployeeOrderScene(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("view/employeeOrderViewUI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEmployeeLoginScene(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("view/employeeLoginViewUI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // public void logout(ActionEvent event) {
    //     Alert alert = new Alert(AlertType.CONFIRMATION);
    //     alert.setTitle("Logout");
    //     alert.setHeaderText
    // }

}
