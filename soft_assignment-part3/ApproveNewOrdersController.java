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

public class ApproveNewOrdersController implements Initializable{
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
    private TableColumn<Order, String> bookName;
    @FXML
    private TableColumn<Order, String> quantity;
    @FXML
    private TableColumn<Order, String> paymentType;

    @FXML
    private TableColumn<Order, String> orderStatus;

    @FXML
    private TableView<Order> table;
    @FXML
    Button approveOrder;
    @FXML
    TextField id;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderId.setCellValueFactory(new PropertyValueFactory<Order , String>("orderId"));
        bookId.setCellValueFactory(new PropertyValueFactory<Order , String>("bookId"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<Order , String>("customerEmail"));
        bookName.setCellValueFactory(new PropertyValueFactory<Order , String>("bookName"));
        quantity.setCellValueFactory(new PropertyValueFactory<Order , String>("quantity"));
        paymentType.setCellValueFactory(new PropertyValueFactory<Order , String>("paymentType"));
        orderStatus.setCellValueFactory(new PropertyValueFactory<Order , String>("orderStatus"));
        
        ObservableList<Order> list = model.getEmployee().getNewOrders();
        table.setItems(list);

        approveOrder.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(id.getText().trim().isEmpty()){
                    showAlert("order id feild is empty");
                }else{
                    model.getEmployee().approveOrder(id.getText());
                    showAlert("order approved successfully");
                    //SceneController.changeScene(event, "/fxml/SearchBooks.fxml", "search result");
                }
                
            }
            
        });

        button_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                SceneController.changeScene(event, "/fxml/login.fxml", "Login");
                
            }
            
        });


    }

    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

}
