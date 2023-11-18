package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class itemMenuController {
    private Stage stage;
    private Scene scene;

    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/itemMenuViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCheesePizza(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/cheesePizzaMenuViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPepperoniPizza(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/pepperoniPizzaMenuViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToThreeMeatPizza(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/threeMeatPizzaMenuViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToVeggiePizza(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/veggiePizzaMenuViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCheesyBread(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/cheesyBreadMenuViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToWings(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/wingsMenuViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDeepDish(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/deepDishMenuViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchTo2LiterSoda(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/twoLiterSodaMenuViewUI.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
