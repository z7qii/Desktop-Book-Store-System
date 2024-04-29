import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.fxml.Initializable;

public class ViewEmployeesController implements Initializable{
    private Model model = new Model();
   
    @FXML
    private TableColumn<Employee, String> id;

    @FXML
    private TableColumn<Employee, String> fName;

    @FXML
    private TableColumn<Employee, String> lName;
    @FXML
    private TableColumn<Employee, String> nationality;
    @FXML
    private TableColumn<Employee, String> gender;
    @FXML
    private TableColumn<Employee, String> dob;

    @FXML
    private TableColumn<Employee, String> tel;
    @FXML
    private TableColumn<Employee, String> email;
    @FXML
    private TableView<Employee> table;
    @FXML
    ImageView checkOrders;
    @FXML
    ImageView searchForBooks;
    @FXML
    ImageView manageBooks;
    @FXML
    ImageView logout;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Employee , String>("id"));
        fName.setCellValueFactory(new PropertyValueFactory<Employee , String>("fName"));
        lName.setCellValueFactory(new PropertyValueFactory<Employee , String>("lName"));
        nationality.setCellValueFactory(new PropertyValueFactory<Employee , String>("nationality"));
        gender.setCellValueFactory(new PropertyValueFactory<Employee , String>("gender"));
        dob.setCellValueFactory(new PropertyValueFactory<Employee , String>("dob"));
        tel.setCellValueFactory(new PropertyValueFactory<Employee , String>("tel"));
        email.setCellValueFactory(new PropertyValueFactory<Employee , String>("email"));

        
        ObservableList<Employee> list = model.getManger().viewEmployees();
        table.setItems(list);

        manageBooks.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneController.changeScene(event, "/fxml/manageBooks.fxml", "manage books");
                
            }
            
        });

        checkOrders.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
            SceneController.changeScene(event, "/fxml/checkOrders_manager.fxml", "search result");
                
                    
            }
            
        });

        searchForBooks.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
            SceneController.changeScene(event, "/fxml/Manage&search_manager.fxml", "search result");
                
                    
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
    

