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

public class mainMenuController {
    private Stage stage;
    private Scene scene;

    @FXML
    private StackPane hoverContent;

    @FXML
    private Button login;

    @FXML
    private StackPane cannotOrderDelivery;

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
        Parent root = FXMLLoader.load(getClass().getResource("view/itemMenuViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
