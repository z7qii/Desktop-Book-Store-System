import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddressController implements Initializable {
    Model model = new Model();
    
    @FXML
    private TextField city;
    @FXML
    private TextField street;
    @FXML
    private TextField postalCode;
    @FXML
    private Button setAddress;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAddress.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(!city.getText().trim().isEmpty() && !street.getText().trim().isEmpty()&& !postalCode.getText().trim().isEmpty()){
                    model.getCustomer().setAddress(new Address(city.getText() , street.getText() , postalCode.getText()));
                    SceneController.changeScene(event, "/fxml/payment.fxml", "payment");
                }else{
                    showAlert("Please fill in all information");
                }
                
            }
            
        });

        
       
        
        
    }

    private void showAlert(String message){
        
       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();

    }

    
}
