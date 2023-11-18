package UI;

import javafx.scene.Parent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class loginCustomer extends Application{
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        try{
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("view/customerRegister.fxml"));
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
