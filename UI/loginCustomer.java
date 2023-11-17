package UI;
import javafx.scene.Parent;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.Node;


public class loginCustomer extends Application{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        try{
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("customerRegister.fxml"));
            Parent parentRoot = (Parent) fxmlloader.load();
            Scene scene = new Scene(parentRoot);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public void switchToScene1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("customerRegister.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }
    public void switchToScene2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("customerRegister2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
