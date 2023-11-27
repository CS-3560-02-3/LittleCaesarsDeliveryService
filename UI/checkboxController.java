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
    private int counter = 1;
    private Stage stage;
    private Scene scene;
    private globalController globalController;
    @FXML
    private CheckBox checkone, checktwo, checkthree, checkfour, checkfive, checksix, checkseven, checkeight;

    @FXML
    private Label driverone, drivertwo, driverthree, driverfour, driverfive, driversix, driverseven, drivereight;
    
    @FXML
    private Label orderone, ordertwo, orderthree, orderfour, orderfive, ordersix, orderseven, ordereight;
    public void initialize(){
        for (String thing: globalController.orders){
            if (counter == 1){
                driverone.setText("DRIVER: nick");
                orderone.setText("ORDER#: " + thing);
            }
            if (counter == 2){
                drivertwo.setText("DRIVER: nick");
                ordertwo.setText("ORDER#: " + thing);
            }
            if (counter == 3){
                driverthree.setText("DRIVER: nick");
                orderthree.setText("ORDER#: " + thing);
            }
            if (counter == 4){
                driverfour.setText("DRIVER: nick");
                orderfour.setText("ORDER#: " + thing);
            }
            if (counter == 5){
                driverfive.setText("DRIVER: nick");
                orderfive.setText("ORDER#: " + thing);
            }
            if (counter == 6){
                driversix.setText("DRIVER: nick");
                ordersix.setText("ORDER#: " + thing);
            }
            if (counter == 7){
                driverseven.setText("DRIVER: nick");
                orderseven.setText("ORDER#: " + thing);
            }
            if (counter == 8){
                drivereight.setText("DRIVER: nick");
                ordereight.setText("ORDER#: " + thing);
            }
            counter++;
            
        }
    }
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
