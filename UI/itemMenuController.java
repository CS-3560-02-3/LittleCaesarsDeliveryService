package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class itemMenuController {
    //global declarations
    private Stage stage;
    private Scene scene;
    private boolean loggedIn;

    //method to set the logged in status
    public void setLoggedInStatus(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    //scene transitions
    public void switchToMenu(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/itemMenuViewUI.fxml"));
        Parent root = loader.load();

        itemMenuController itemmenucontroller = loader.getController();
        itemmenucontroller.setLoggedInStatus(loggedIn);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCheesePizza(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/cheesePizzaMenuViewUI.fxml"));
        Parent root = loader.load();

        itemMenuController itemmenucontroller = loader.getController();
        itemmenucontroller.setLoggedInStatus(loggedIn);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPepperoniPizza(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/pepperoniPizzaMenuViewUI.fxml"));
        Parent root = loader.load();

        itemMenuController itemmenucontroller = loader.getController();
        itemmenucontroller.setLoggedInStatus(loggedIn);
        
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToThreeMeatPizza(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/threeMeatPizzaMenuViewUI.fxml"));
        Parent root = loader.load();

        itemMenuController itemmenucontroller = loader.getController();
        itemmenucontroller.setLoggedInStatus(loggedIn);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToVeggiePizza(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/veggiePizzaMenuViewUI.fxml"));
        Parent root = loader.load();

        itemMenuController itemmenucontroller = loader.getController();
        itemmenucontroller.setLoggedInStatus(loggedIn);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCheesyBread(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/cheesyBreadMenuViewUI.fxml"));
        Parent root = loader.load();

        itemMenuController itemmenucontroller = loader.getController();
        itemmenucontroller.setLoggedInStatus(loggedIn);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToWings(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/wingsMenuViewUI.fxml"));
        Parent root = loader.load();

        itemMenuController itemmenucontroller = loader.getController();
        itemmenucontroller.setLoggedInStatus(loggedIn);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDeepDish(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/deepDishMenuViewUI.fxml"));
        Parent root = loader.load();

        itemMenuController itemmenucontroller = loader.getController();
        itemmenucontroller.setLoggedInStatus(loggedIn);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchTo2LiterSoda(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/twoLiterSodaMenuViewUI.fxml"));
        Parent root = loader.load();

        itemMenuController itemmenucontroller = loader.getController();
        itemmenucontroller.setLoggedInStatus(loggedIn);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //checks to see whether or not a user is logged in, then take them to the desired main menu
    public void switchToMainMenu(ActionEvent e) throws IOException {
        if (!loggedIn) {
            Parent root = FXMLLoader.load(getClass().getResource("view/mainMenu.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
} //end itemMenuController
