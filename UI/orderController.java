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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class orderController {
    //JDBC connection
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "ilovemysql23";

    //Stage and Scene declaration
    private Stage stage;
    private Scene scene;
    
    //Calling the global Controller in order to instantiate a globalController Object
    globalController globalcontroller = globalController.instantiateGlobalController();
    //Using the globalController Object in order to instantiate the customer's orderList
    order orderList = globalcontroller.getOrder();
    //assigning the orderlist to the customer
    
    //initialize menu item objects
    menuItems CheesePizza = new menuItems(1);
    menuItems PepperoniPizza = new menuItems(2);
    menuItems ThreeMeatTreatPizza = new menuItems(3);
    menuItems VeggiePizza = new menuItems(4);
    menuItems DeepDishPizza = new menuItems(5);
    menuItems Wings = new menuItems(6);
    menuItems CrazyBread = new menuItems(7);
    menuItems Soda = new menuItems(8);

    //Declare buttons and texts from the fxml file
    @FXML
    private Button cheeseA;

    @FXML
    private Button pepperoniA;

    @FXML
    private Button meatA;

    @FXML
    private Button veggieA;

    @FXML
    private Button deepDishA;

    @FXML
    private Button wingsA;

    @FXML
    private Button crazyBreadA;

    @FXML
    private Button sodaA;

    @FXML
    private Button cheeseR;

    @FXML
    private Button pepperoniR;

    @FXML
    private Button meatR;

    @FXML
    private Button veggieR;

    @FXML
    private Button deepDishR;

    @FXML
    private Button wingsR;

    @FXML
    private Button crazyBreadR;

    @FXML
    private Button sodaR;

    @FXML
    private Button cheeseView;

    @FXML
    private Button pepperoniView;

    @FXML
    private Button meatView;

    @FXML
    private Button veggieView;

    @FXML
    private Button deepDishView;

    @FXML
    private Button wingsView;

    @FXML
    private Button crazyBreadView;

    @FXML
    private Button sodaView;

    @FXML
    private Text cheeseCounter;

    @FXML
    private Text pepperoniCounter;

    @FXML
    private Text meatCounter;

    @FXML
    private Text veggieCounter;

    @FXML
    private Text deepDishCounter;

    @FXML
    private Text wingsCounter;

    @FXML
    private Text crazyBreadCounter;

    @FXML
    private Text sodaCounter;

    //initializer method in order to set the counters to their right values
    public void initialize() {
        if (cheeseCounter != null)
            cheeseCounter.setText(String.valueOf(orderList.getCounterValue(CheesePizza)));
        if (pepperoniCounter != null)
            pepperoniCounter.setText(String.valueOf(orderList.getCounterValue(PepperoniPizza)));
        if (meatCounter != null)
            meatCounter.setText(String.valueOf(orderList.getCounterValue(ThreeMeatTreatPizza)));
        if (veggieCounter != null)
            veggieCounter.setText(String.valueOf(orderList.getCounterValue(VeggiePizza)));
        if (deepDishCounter != null)
            deepDishCounter.setText(String.valueOf(orderList.getCounterValue(DeepDishPizza)));
        if (wingsCounter != null)
            wingsCounter.setText(String.valueOf(orderList.getCounterValue(Wings)));
        if (crazyBreadCounter != null)
            crazyBreadCounter.setText(String.valueOf(orderList.getCounterValue(CrazyBread)));
        if (sodaCounter != null)
            sodaCounter.setText(String.valueOf(orderList.getCounterValue(Soda)));
    }

    //method to add an item to the cart
    public void AddingToCart(ActionEvent event) {
        Button clickedButton = (Button) event.getSource(); 
        String buttonID = clickedButton.getId();

        switch (buttonID) {
            case "cheeseA":
            case "cheeseView":
                orderList.addItemToCart(CheesePizza);
                addCounter(CheesePizza, cheeseCounter);
                break;
            case "pepperoniA":
            case "pepperoniView":
                orderList.addItemToCart(PepperoniPizza);
                addCounter(PepperoniPizza, pepperoniCounter);
                break;
            case "meatA":
            case "meatView":
                orderList.addItemToCart(ThreeMeatTreatPizza);
                addCounter(ThreeMeatTreatPizza, meatCounter);
                break;
            case "veggieA":
            case "veggieView":
                orderList.addItemToCart(VeggiePizza);
                addCounter(VeggiePizza, veggieCounter);
                break;
            case "deepDishA":
            case "deepDishView":
                orderList.addItemToCart(DeepDishPizza);
                addCounter(DeepDishPizza, deepDishCounter);
                break;
            case "wingsA":
            case "wingsView":
                orderList.addItemToCart(Wings);
                addCounter(Wings, wingsCounter);
                break;
            case "crazyBreadA":
            case "crazyBreadView":
                orderList.addItemToCart(CrazyBread);
                addCounter(CrazyBread, crazyBreadCounter);
                break;
            case "sodaA":
            case "sodaView":
                orderList.addItemToCart(Soda);
                addCounter(Soda, sodaCounter);
                break;
        }
        orderList.updateOrderList(orderList.getOrderList());
    } //end addingToCart

    //helper method to increment the counter on both the frontend and backend
    private void addCounter(menuItems item, Text counterText) {
        int currentCounterBackend = orderList.getCounterValue(item);
        orderList.updateCounter(item, currentCounterBackend + 1);

        int currentCounterFrontEnd = Integer.parseInt(counterText.getText());
        counterText.setText(String.valueOf(currentCounterFrontEnd + 1));
    } //end addCounter

    //method to remove an item from the cart
    public void RemovingFromCart(ActionEvent event) {
        Button clickedButton = (Button) event.getSource(); 
        String buttonID = clickedButton.getId();

        switch (buttonID) {
            case "cheeseR":
                orderList.removeItemFromCart(CheesePizza);
                subtractCounter(CheesePizza, cheeseCounter);
                break;
            case "pepperoniR":
                orderList.removeItemFromCart(PepperoniPizza);
                subtractCounter(PepperoniPizza, pepperoniCounter);
                break;
            case "meatR":
                orderList.removeItemFromCart(ThreeMeatTreatPizza);
                subtractCounter(ThreeMeatTreatPizza, meatCounter);
                break;
            case "veggieR":
                orderList.removeItemFromCart(VeggiePizza);
                subtractCounter(VeggiePizza, veggieCounter);
                break;
            case "deepDishR":
                orderList.removeItemFromCart(DeepDishPizza);
                subtractCounter(DeepDishPizza, deepDishCounter);
                break;
            case "wingsR":
                orderList.removeItemFromCart(Wings);
                subtractCounter(Wings, wingsCounter);
                break;
            case "crazyBreadR":
                orderList.removeItemFromCart(CrazyBread);
                subtractCounter(CrazyBread, crazyBreadCounter);
                break;
            case "sodaR":
                orderList.removeItemFromCart(Soda);
                subtractCounter(Soda, sodaCounter);
                break;
        }
        orderList.updateOrderList(orderList.getOrderList());
    } //end RemovingFromCart

    //helper method to decrement the counter on both the frontend and backend
    private void subtractCounter(menuItems item, Text counterText) {
        int currentCounterBackEnd = orderList.getCounterValue(item);
        if (currentCounterBackEnd > 0)
            orderList.updateCounter(item, currentCounterBackEnd - 1);

        int currentCounterFrontEnd = Integer.parseInt(counterText.getText());
        if (currentCounterFrontEnd > 0)
            counterText.setText(String.valueOf(currentCounterFrontEnd - 1));
    } //end subtractCounter

    //scene transition methods
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/cartUI.fxml"));
        Parent root = loader.load();

        cartController cartcontroller = loader.getController();
        cartcontroller.setOrderList(orderList);
        
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
} //end orderController