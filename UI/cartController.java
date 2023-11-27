package UI;

import java.io.IOException;
import java.util.ArrayList;

import Model.menuItems;
import Model.order;

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

public class cartController {
    //JDBC connection
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/littlecaesars";
    static final String USER = "root";
    static final String PASSWORD = "littleCaesars";
    //static final String PASSWORD = "ilovemysql23";

    //global declarations
    private Stage stage;
    private Scene scene;
    private order orderList;
    private int tip;
    
    //instantiate the GlobalController to retreive the order and customer data
    globalController GlobalController = globalController.getGlobalController();

    //FXML declarations
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox order_items;

    @FXML
    private Text CostText;

    @FXML
    private Text CustomerText;

    @FXML
    private Text AddressText;

    @FXML
    private RadioButton tip1;

    @FXML
    private RadioButton tip2;

    @FXML
    private RadioButton tip3;
    
    @FXML
    private RadioButton tip0;
    
    //method to initalize the screen
    public void initialize() {
        orderList = GlobalController.getOrder();
        displayItemsToScreen();
        displayTotalCost();
    } //end initialize

    //method to display the items that the user added to the cart
    public void displayItemsToScreen() {
        order_items.getChildren().clear();
        ArrayList<menuItems> duplicates = new ArrayList<>();

        if (orderList != null) {
            for (menuItems item : orderList.getOrderList()) {
                if (!duplicates.contains(item) && orderList.getCounterValue(item) != 0) {
                    Pane itemPane = createItemPane(item);
                    order_items.getChildren().add(itemPane);
                    duplicates.add(item);
                }
            }
        }
        scrollPane.setContent(order_items);
    } //end displayItemsToScreen

    //private method to create the item panes to attach to the VBox
    private Pane createItemPane(menuItems item) {
        Pane pane = new Pane();

        ImageView image;

        switch(item.getName()) {
            case "cheese pizza":
                image = new ImageView(getClass().getResource("/Pictures/cheesePizza.jpg").toExternalForm());
                break;
            case "pepperoni pizza":
                image = new ImageView(getClass().getResource("/Pictures/PepperoniPizza.jpg").toExternalForm());
                break;
            case "three meat treat":
                image = new ImageView(getClass().getResource("/Pictures/threeMeatTreat.jpg").toExternalForm());
                break;
            case "veggie pizza":
                image = new ImageView(getClass().getResource("/Pictures/veggiePizza.jpg").toExternalForm());
                break;
            case "deep dish pizza":
                image = new ImageView(getClass().getResource("/Pictures/deepDish.jpg").toExternalForm());
                break;
            case "caesar wings":
                image = new ImageView(getClass().getResource("/Pictures/caesarWings.jpg").toExternalForm());
                break;
            case "crazy bread":
                image = new ImageView(getClass().getResource("/Pictures/crazyBread.jpg").toExternalForm());
                break;
            case "two liter soda":
                image = new ImageView(getClass().getResource("/Pictures/twoLiter.jpg").toExternalForm());
                break;
            default:
                image = new ImageView(getClass().getResource("/Pictures/pepperoniPizzaGuy.jpg").toExternalForm());
        }
        image.setFitHeight(100);
        image.setFitWidth(150);
        pane.getChildren().add(image);

        Text text = new Text(item.getName() + "    x" + orderList.getCounterValue(item));
        text.setFont(new Font(18));
        text.setLayoutX(300);
        text.setLayoutY(50);
        pane.getChildren().add(text);
        return pane;
    } //end createItemPane

    //method to display the total cost
    public void displayTotalCost() {
        orderList.calculateTotalCost();
        CostText.setText("TOTAL COST: $" + String.valueOf(orderList.getTotalCost()));
    } //end displayTotalCost

    //method to add the tip to the Order object
    @FXML
    public void addTip() {
        if (tip1.isSelected())
            tip = 1;
        else if (tip2.isSelected())
            tip = 2;
        else if (tip3.isSelected())
            tip = 3;
        else if (tip0.isSelected())
            tip = 0;
    } 

    //When the user is ready to confirm their order, the order is inserted into the database and the object is wiped for the next customer who orders
    public void switchToConfirmationScreen(ActionEvent e) throws IOException {
        orderList.setTip(tip);
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO `order` (orderID, dateOrdered, tip, customerID) VALUES (?, ?, ?, ?);");
            preparedStatement.setInt(1, orderList.getOrderID());
            preparedStatement.setInt(2, orderList.getDateOrdered());
            preparedStatement.setInt(3, orderList.getTip());
            preparedStatement.setInt(4, GlobalController.getCustomerID());

            preparedStatement.executeUpdate();
            System.out.println("Order info inserted into Database");
        }
        catch (Exception error) {
            error.printStackTrace();
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } 
                catch (SQLException error) {
                    error.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (SQLException error) {
                    error.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException error) {
                    error.printStackTrace();
                }
            }
        }

        //Delete the order from the global controller
        GlobalController.deleteOrder();

        //switch scenes
        Parent root = FXMLLoader.load(getClass().getResource("view/confirmationScreenUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } //end switchToConfirmationScreen

    //scene transitions
    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/orderViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
} //end cartController
