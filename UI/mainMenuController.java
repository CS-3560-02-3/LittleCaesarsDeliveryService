package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class mainMenuController {
    private Stage stage;
    private Scene scene;
    private boolean loggedIn = false;

    @FXML
    private StackPane hoverContent;

    @FXML
    private Button login;

    @FXML
    private StackPane cannotOrderDelivery;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private void initialize() {
        hoverContent.setVisible(false);
        cannotOrderDelivery.setVisible(false);
    }

    @FXML
    private void showHoverContent() {
        hoverContent.setVisible(true);
    }

    @FXML
    private void hideHoverContent() {
        hoverContent.setVisible(false);
    }

    @FXML
    private void showCannotOrder() {
        cannotOrderDelivery.setVisible(true);
    }

    @FXML
    private void hideCannotOrder() {
        cannotOrderDelivery.setVisible(false);
    }


        
    @FXML
    private void switchToUserLogin(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/customerLoginViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToEmployeeLogin(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/employeeLoginViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToItemMenu(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/itemMenuViewUI.fxml"));
        Parent root = loader.load();

        itemMenuController Item = loader.getController();
        Item.setLoggedInStatus(loggedIn);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // private void loginButtonOnAction(ActionEvent e) {

    //     if(usernameTextField.getText().isEmpty() && passwordPasswordField.getText().isEmpty()) {
    //         loginMessageLabel.setText("Please enter username and password");
    //     }

    // }
}
