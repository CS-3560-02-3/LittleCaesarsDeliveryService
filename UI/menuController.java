package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class menuController {
    private Stage stage;
    private Scene scene;
    private boolean loggedIn = true;

    @FXML
    private StackPane hoverContent;

    @FXML
    private Button login;

    private boolean loggedIn = true;

    @FXML
    private void initialize() {
        if (hoverContent != null)
            hoverContent.setVisible(false);
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


    public void switchToEdit(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("view/menuEdit.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }

    public void switchToMenu(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logOut(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("view/mainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void orderDelivery(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("view/orderViewUI.fxml"));
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
