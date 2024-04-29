import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SceneController {
    public static void changeScene(ActionEvent event, String fxmlFile, String title) {
        Parent root = null;
        
        
            try {
                root = FXMLLoader.load(SceneController.class.getResource(fxmlFile));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root, 1050, 750));
                stage.setResizable(true);
                stage.setTitle(title);
                stage.show();
                
        
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        
        

    }

    public static void changeScene(MouseEvent event, String fxmlFile, String title) {
        Parent root = null;
        
        
            try {
                root = FXMLLoader.load(SceneController.class.getResource(fxmlFile));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root, 1050, 750));
                stage.setResizable(true);
                stage.setTitle(title);
                stage.show();
                
        
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        
        

    }

}
