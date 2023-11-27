package UI;

import java.io.IOException;
import Model.customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class menuController {
    private Stage stage;
    private Scene scene;
    private boolean loggedIn = true;
    @FXML
    private StackPane hoverContent;

    @FXML
    private Button login;

    @FXML
    private Text userName;

    // globalController GlobalController = globalController.instantiateGlobalController();
    globalController GlobalController = globalController.getGlobalController();

    @FXML
    public void initialize() {
        if (hoverContent != null)
            hoverContent.setVisible(false);
        
        // retrieve currently logged in customer by ID
        int currentCustomerID = GlobalController.getCustomerID();
        System.out.println("Current Customer ID: " + currentCustomerID);

        System.out.println("Switched to logged in menu page");
        customer Customer = new customer(currentCustomerID);
        
        userName.setText("Hi, " + Customer.getName());
    }

    @FXML
    private void showHoverContent() {
        if (hoverContent != null)
            hoverContent.setVisible(true);
    }

    @FXML
    private void hideHoverContent() {
        if (hoverContent != null)
            hoverContent.setVisible(false);
    }

    // method to switch to edit account page
    public void switchToEdit(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/menuEdit.fxml"));
        Parent root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }

    // // 
    // public void switchToMenu(ActionEvent event) throws IOException{
    //     Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
    //     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    //     scene = new Scene(root);
    //     stage.setScene(scene);
    //     stage.show();
    // }

    // method to switch to first page, essentially to log out
    public void logOut(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("view/mainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method to switch to orderDelivery page
    public void orderDelivery(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/orderViewUI.fxml"));
        Parent root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void itemMenu(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/itemMenuViewUI.fxml"));
        Parent root = loader.load();

        itemMenuController Item = loader.getController();
        Item.setLoggedInStatus(loggedIn);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
