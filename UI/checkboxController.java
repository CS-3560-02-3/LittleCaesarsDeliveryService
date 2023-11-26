package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class checkboxController {
    private Stage stage;
    private Scene scene;
    private globalController globalController;
    @FXML
    private CheckBox checkone, checktwo, checkthree, checkfour, checkfive, checksix, checkseven, checkeight;

    @FXML
    private Label driverone, drivertwo, driverthree, driverfour, driverfive, driversix, driverseven, drivereight;
    
    @FXML
    private Label orderone, ordertwo, orderthree, orderfour, orderfive, ordersix, orderseven, ordereight;

    public void delete(ActionEvent event) throws IOException{
        if (checkone.isSelected()){
            driverone.setText("DRIVER:");
            orderone.setText("Order #");
        }
        if (checktwo.isSelected()){
            drivertwo.setText("DRIVER:");
            ordertwo.setText("Order #");
        }
        if (checkthree.isSelected()){
            driverthree.setText("DRIVER:");
            orderthree.setText("Order #");
        }
        if (checkfour.isSelected()){
            driverfour.setText("DRIVER:");
            orderfour.setText("Order #");
        }
        if (checkfive.isSelected()){
            driverfive.setText("DRIVER:");
            orderfive.setText("Order #");
        }
        if (checksix.isSelected()){
            driversix.setText("DRIVER:");
            ordersix.setText("Order #");
        }
        if (checkseven.isSelected()){
            driverseven.setText("DRIVER:");
            orderseven.setText("Order #");
        }
        if (checkeight.isSelected()){
            drivereight.setText("DRIVER:");
            ordereight.setText("Order #");
        }
    } 
    public void signOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/mainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }   
}
