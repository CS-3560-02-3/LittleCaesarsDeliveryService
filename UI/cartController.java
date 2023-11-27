package UI;

import java.io.IOException;
import java.util.ArrayList;

import Model.customer;
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

    private Stage stage;
    private Scene scene;
    globalController GlobalController = globalController.getGlobalController();
    private order orderList;
    private customer Customer;
    private int tip;

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
    

    public void initialize() {
        orderList = GlobalController.getOrder();
        Customer = GlobalController.getCurrentCustomer();
        displayItemsToScreen();
        displayTotalCost();
    }


   /*  public void setGlobalController(globalController globalcontroller) {
        this.globalcontroller = globalcontroller;
        setOrderList();
    }
    
    public void setOrderList() {
        this.orderList = globalcontroller.getCurrentOrder(); 
        //this.Customer = globalcontroller.getCurrentCustomer();
        
    }
 */
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
    }

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
    }

    public void displayTotalCost() {
        orderList.calculateTotalCost();
        CostText.setText("TOTAL COST: $" + String.valueOf(orderList.getTotalCost()));
    }

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

    public void switchToConfirmationScreen(ActionEvent e) throws IOException {
        orderList.setTip(tip);
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            /* connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE `order` SET tip = ?, customerID = ? WHERE orderID = ? ");

            preparedStatement.setInt(1, tip);
            preparedStatement.setInt(2, GlobalController.getCustomerID());
            preparedStatement.setInt(3, orderList.getOrderID());

            preparedStatement.executeUpdate();
            System.out.println("order has been updated with the right attributes in cartController"); */

            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO `order` (orderID, dateOrdered, tip, customerID) VALUES (?, ?, ?, ?);");
            preparedStatement.setInt(1, orderList.getOrderID());
            preparedStatement.setInt(2, orderList.getDateOrdered());
            preparedStatement.setInt(3, orderList.getTip());
            preparedStatement.setInt(4, GlobalController.getCustomerID());

            preparedStatement.executeUpdate();
            System.out.println("INSERT");
            /* preparedStatement.setInt(1, orderList.getOrderID());
            preparedStatement.setInt(2, orderList.getDateOrdered());
            preparedStatement.setInt(3, orderList.getTip());
            preparedStatement.setInt(4, Customer.getCustomerID()); */
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
}
