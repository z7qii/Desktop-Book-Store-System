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

public class ViewManagersController implements Initializable {
    private Model model = new Model();
   
    @FXML
    private TableColumn<Manager, String> id;

    @FXML
    private TableColumn<Manager, String> fName;

    @FXML
    private TableColumn<Manager, String> lName;
    @FXML
    private TableColumn<Manager, String> nationality;
    @FXML
    private TableColumn<Manager, String> gender;
    @FXML
    private TableColumn<Manager, String> dob;

    @FXML
    private TableColumn<Manager, String> tel;
    @FXML
    private TableColumn<Manager, String> email;
    @FXML
    private TableView<Manager> table;
    @FXML
    ImageView viewSales;
    @FXML
    ImageView logout;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Manager , String>("id"));
        fName.setCellValueFactory(new PropertyValueFactory<Manager , String>("fName"));
        lName.setCellValueFactory(new PropertyValueFactory<Manager , String>("lName"));
        nationality.setCellValueFactory(new PropertyValueFactory<Manager , String>("nationality"));
        gender.setCellValueFactory(new PropertyValueFactory<Manager , String>("gender"));
        dob.setCellValueFactory(new PropertyValueFactory<Manager , String>("dob"));
        tel.setCellValueFactory(new PropertyValueFactory<Manager , String>("tel"));
        email.setCellValueFactory(new PropertyValueFactory<Manager , String>("email"));

        
        ObservableList<Manager> list = model.getAdministrator().viewManagers();
        table.setItems(list);

        viewSales.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneController.changeScene(event, "/fxml/viewSales.fxml", "manage books");
                
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
    

