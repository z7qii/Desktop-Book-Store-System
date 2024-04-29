import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class viewSalesController implements Initializable {
    Model model = new Model();
    @FXML
    Label salesMonth;
    @FXML
    Label salesWeek;
    @FXML
    Label salesDay;
    @FXML
    ImageView viewManagers;
    @FXML
    ImageView logout;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String sales = model.getAdministrator().viewSales().toString();
        salesMonth.setText(sales);
        salesWeek.setText(sales);
        salesDay.setText(sales);

        viewManagers.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneController.changeScene(event, "/fxml/viewManagers.fxml", "manage books");
                
            }
            
        });

        logout.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                
                SceneController.changeScene(event, "/fxml/Login.fxml", "cart");    
                
            }
            
        });
    }
    
}
