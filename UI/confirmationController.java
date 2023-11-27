package UI;

import java.io.IOException;


import java.io.IOException;
import java.util.ArrayList;

import Model.customer;
import Model.menuItems;
import Model.order;
import Model.driver;
import Model.delivery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.text.Text;

public class confirmationController {
    private Stage stage;
    private Scene scene;
    globalController GlobalController = globalController.getGlobalController();
    private order orderList;
    private driver drivers;
    private delivery deliveries;
    @FXML
    private Text timeLabel;

    @FXML
    private Text driverLabel;

    public void initialize(){
        //orderList = GlobalController.getOrder();
        //int id = orderList.getOrderID();
        //drivers = new driver(5, "Josh", "testing123", "Joshua", "AS28942");
        drivers = new driver(1);
        deliveries = new delivery(1);
        timeLabel.setText(deliveries.getEstimatedTime() + " seconds");
        driverLabel.setText("" + drivers.getName());
        
    }

    public void switchToMainMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
} //end confirmationController
