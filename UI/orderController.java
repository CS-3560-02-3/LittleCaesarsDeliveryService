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

public class orderController {
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";

    private Stage stage;
    private Scene scene;
    
    globalController globalcontroller = globalController.instantiateGlobalController();

    order orderList = globalcontroller.getOrder();
    
    menuItems CheesePizza = new menuItems(1);
    menuItems PepperoniPizza = new menuItems(2);
    menuItems ThreeMeatTreatPizza = new menuItems(3);
    menuItems VeggiePizza = new menuItems(4);
    menuItems DeepDishPizza = new menuItems(5);
    menuItems Wings = new menuItems(6);
    menuItems CrazyBread = new menuItems(7);
    menuItems Soda = new menuItems(8);

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
    private Button drinkA;

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
    private Button drinkR;

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

    public void AddingToCart(ActionEvent event) {
        Button clickedButton = (Button) event.getSource(); 
        String buttonID = clickedButton.getId();

        switch (buttonID) {
            case "cheeseA":
                orderList.addItemToCart(CheesePizza);
                addCounter(cheeseCounter);
                break;
            case "pepperoniA":
                orderList.addItemToCart(PepperoniPizza);
                addCounter(pepperoniCounter);
                break;
            case "meatA":
                orderList.addItemToCart(ThreeMeatTreatPizza);
                addCounter(meatCounter);
                break;
            case "veggieA":
                orderList.addItemToCart(VeggiePizza);
                addCounter(veggieCounter);
                break;
            case "deepDishA":
                orderList.addItemToCart(DeepDishPizza);
                addCounter(deepDishCounter);
                break;
            case "wingsA":
                orderList.addItemToCart(Wings);
                addCounter(wingsCounter);
                break;
            case "crazyBreadA":
                orderList.addItemToCart(CrazyBread);
                addCounter(crazyBreadCounter);
                break;
            case "sodaA":
                orderList.addItemToCart(Soda);
                addCounter(sodaCounter);
                break;
        }
    }

    private void addCounter(Text counterText) {
        int currentCounter = Integer.parseInt(counterText.getText());
        counterText.setText(String.valueOf(currentCounter + 1));
    }

    public void RemovingFromCart(ActionEvent event) {
        Button clickedButton = (Button) event.getSource(); 
        String buttonID = clickedButton.getId();

        switch (buttonID) {
            case "cheeseR":
                orderList.removeItemFromCart(CheesePizza);
                subtractCounter(cheeseCounter);
                break;
            case "pepperoniR":
                orderList.removeItemFromCart(PepperoniPizza);
                subtractCounter(pepperoniCounter);
                break;
            case "meatR":
                orderList.removeItemFromCart(ThreeMeatTreatPizza);
                subtractCounter(meatCounter);
                break;
            case "veggieR":
                orderList.removeItemFromCart(VeggiePizza);
                subtractCounter(veggieCounter);
                break;
            case "deepDishR":
                orderList.removeItemFromCart(DeepDishPizza);
                subtractCounter(deepDishCounter);
                break;
            case "wingsR":
                orderList.removeItemFromCart(Wings);
                subtractCounter(wingsCounter);
                break;
            case "crazyBreadR":
                orderList.removeItemFromCart(CrazyBread);
                subtractCounter(crazyBreadCounter);
                break;
            case "sodaR":
                orderList.removeItemFromCart(Soda);
                subtractCounter(sodaCounter);
                break;
        }
    }

    private void subtractCounter(Text counterText) {
        int currentCounter = Integer.parseInt(counterText.getText());
        counterText.setText(String.valueOf(currentCounter - 1));
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
