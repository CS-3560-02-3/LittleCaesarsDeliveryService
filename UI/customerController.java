package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class customerController {
    private Stage stage;
    private Scene scene;

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
        Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
