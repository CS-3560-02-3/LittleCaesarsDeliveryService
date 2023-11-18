package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class employeeOrderController {
    private Stage stage;
    private Scene scene;

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

}
