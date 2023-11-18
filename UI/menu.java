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


public class menu extends Application{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        try{
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("view/menu.fxml"));
            Parent parentRoot = (Parent) fxmlloader.load();
            Scene scene = new Scene(parentRoot);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
}
