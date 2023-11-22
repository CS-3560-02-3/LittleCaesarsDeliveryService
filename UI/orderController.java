package UI;
import Model.menuItems;
import Model.order;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class orderController {
    static final String DB_URL = "jdbc:mysql://localhost:3306/CS3560";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";

    private Stage stage;
    private Scene scene;
    order orderList = new order(0, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0);
    menuItems CheesePizza = new menuItems(0, DB_URL, 0);
    menuItems PepperoniPizza = new menuItems(0, DB_URL, 0);
    menuItems ThreeMeatTreatPizza = new menuItems(0, DB_URL, 0);
    menuItems VeggiePizza = new menuItems(0, DB_URL, 0);
    menuItems DeepDishPizza = new menuItems(0, DB_URL, 0);
    menuItems Wings = new menuItems(0, DB_URL, 0);
    menuItems CrazyBread = new menuItems(0, DB_URL, 0);
    menuItems Soda = new menuItems(0, DB_URL, 0);

    @FXML
    private Button cheese;

    @FXML
    private Button pepperoni;

    @FXML
    private Button meat;

    @FXML
    private Button veggie;

    @FXML
    private Button deepDish;

    @FXML
    private Button wings;

    @FXML
    private Button crazyBread;

    @FXML
    private Button drink;

    public void AddingToCart(ActionEvent event) {
        Button clickedButton = (Button) event.getSource(); 
        String buttonID = clickedButton.getId();

        switch (buttonID) {
            case "cheese":
                orderList.addItemToCart(CheesePizza);
                break;
            case "pepperoni":
                orderList.addItemToCart(PepperoniPizza);
                break;
            case "meat":
                orderList.addItemToCart(ThreeMeatTreatPizza);
                break;
            case "veggie":
                orderList.addItemToCart(VeggiePizza);
                break;
            case "deepDish":
                orderList.addItemToCart(DeepDishPizza);
                break;
            case "wings":
                orderList.addItemToCart(Wings);
                break;
            case "crazyBread":
                orderList.addItemToCart(CrazyBread);
                break;
            case "drinks":
                orderList.addItemToCart(Soda);
                break;
        }
    }

    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/orderViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCheesePizza(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/cheesePizzaViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPepperoniPizza(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/pepperoniPizzaViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToThreeMeatPizza(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/threeMeatPizzaViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToVeggiePizza(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/veggiePizzaViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCheesyBread(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/cheesyBreadViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToWings(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/wingsViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDeepDish(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/deepDishViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchTo2LiterSoda(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/twoLiterSodaViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCart(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/cartUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToConfirmationScreen(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/confirmationScreenUI.fxml"));
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
