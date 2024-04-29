import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class OrderHistoryController implements Initializable{

    Model model = new Model();
    ArrayList <Order> orders = model.getCustomer().getOrderHistory();
    @FXML
    ImageView viewCart;
    @FXML
    ImageView Home;
    @FXML
    ImageView Logout;
    @FXML
    ImageView history;
    @FXML
    ImageView orderStatus;
    @FXML
    ImageView changePassword;
    @FXML
    VBox ordersContainer;
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setPage();

        Logout.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                
                SceneController.changeScene(event, "/fxml/Login.fxml", "cart");    
                
            }
            
        });

        orderStatus.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
              
                
                SceneController.changeScene(event, "/fxml/orderStatus.fxml", "cart");    
                
            }
            
        });


        Home.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                
                SceneController.changeScene(event, "/fxml/cusHomePage.fxml", "cart");    
                
            }
            
        });

        viewCart.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
            
                SceneController.changeScene(event, "/fxml/viewCart.fxml", "cart");    
                
            }
            
        });

        

        history.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                SceneController.changeScene(event, "/fxml/history.fxml", "orderHistory");    
            }
            
        });

        changePassword.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                SceneController.changeScene(event, "/fxml/changePassword.fxml", "orderStatus");    
            }
            
        });
        
        
    }

    public void setPage(){
        Double totlPrice = 0.0;
        try{
            for(int i = 0 ; i < orders.size() ; i++){
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/orderStatusLayout.fxml"));
                AnchorPane anch;
                anch = fxmlLoader.load();
                orderLayoutController order = fxmlLoader.getController();
                order.setData(orders.get(i));
                totlPrice += orders.get(i).getTotal();
                ordersContainer.getChildren().add(anch);
                
            }
           
            
        }catch (IOException e) {
            
            e.printStackTrace();
        }
    
    }
    
}
