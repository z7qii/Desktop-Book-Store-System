import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
public class viewOrdersController implements Initializable{
    private Model model = new Model();
    @FXML
    private Button button_back;
    @FXML
    private TableColumn<Order, String> orderId;

    @FXML
    private TableColumn<Order, String> bookId;

    @FXML
    private TableColumn<Order, String> customerEmail;
  
    @FXML
    private TableView<Order> table;
   
    @FXML
    ImageView searchForBooks;
    @FXML
    ImageView manageBooks;
    @FXML
    ImageView viewEmployees;
    @FXML
    ImageView logout;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderId.setCellValueFactory(new PropertyValueFactory<Order , String>("orderId"));
        bookId.setCellValueFactory(new PropertyValueFactory<Order , String>("bookId"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<Order , String>("customerEmail"));
        
        ObservableList<Order> list = model.getManger().getOrders();
        table.setItems(list);

        manageBooks.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneController.changeScene(event, "/fxml/manageBooks.fxml", "manage books");
                
            }
            
        });

       
        searchForBooks.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
            SceneController.changeScene(event, "/fxml/Manage&search_manager.fxml", "search result");
                
                    
            }
            
        });

        viewEmployees.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
            SceneController.changeScene(event, "/fxml/viewEmployees.fxml", "search result");
                
                    
            }
            
        });

        logout.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneController.changeScene(event, "/fxml/login.fxml", "Login"); 
            }
            
        });
    

        
    }


    
}
