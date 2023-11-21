package Database;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class DButil {
    private Stage stage;
    private Scene scene;

    public void changeScene(ActionEvent event, String FXMLpath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(FXMLpath));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void customerSignUp(ActionEvent event, String username, String password, String name, String address, int cardNumber, int cardDate, int cardCVV) {
        
    }

}
