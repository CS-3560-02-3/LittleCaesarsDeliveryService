package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class customerController {
    private Stage stage;
    private Scene scene;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label loginMessageLabel;

    public void switchToCreateCustomerAccount(ActionEvent event) throws IOException{
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
        
        if(usernameTextField.getText().isEmpty() && passwordPasswordField.getText().isEmpty()) {
            loginMessageLabel.setText("Please enter username and password");
        }
        else {
            Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
    }
}
