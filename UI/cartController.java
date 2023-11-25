package UI;

import java.io.IOException;

import Model.menuItems;
import Model.order;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class cartController {
    private Stage stage;
    private Scene scene;
    private order orderList;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox order_item;

    public void setOrderList(order orderList) {
        this.orderList = orderList;
    }

    public void displayItemsToScreen() {
        if (orderList != null) {
            for (menuItems item : orderList.getOrderList()) {
                Pane itemPane = createItemPane(item);
                order_item.getChildren().add(itemPane);
            }
        }
    }

    private Pane createItemPane(menuItems item) {
        Pane pane = new Pane();
        pane.setPrefHeight(50);

        //NICK WORK ON THE POPULATION OF THE PANE SO THE DETAILS AND QUANTITY ARE ON THE PANE
        return pane;
    }

    public void switchToConfirmationScreen(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/confirmationScreenUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/orderViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMainMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
