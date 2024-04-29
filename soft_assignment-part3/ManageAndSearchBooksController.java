import javafx.fxml.Initializable;
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
public class ManageAndSearchBooksController implements Initializable{
    private Model model = new Model();
   
    
    @FXML
    private TableColumn<Book2, String> bookId;

    @FXML
    private TableColumn<Book2, String> bookCategory;

    @FXML
    private TableColumn<Book2, String> bookAuthor;
    @FXML
    private TableColumn<Book2, String> bookQuantity;
    @FXML
    private TableColumn<Book2, String> bookPrice;
   
    @FXML
    private TableView<Book2> table;
    @FXML
    ImageView viewEmployees;
    @FXML
    ImageView checkOrders;
    @FXML
    ImageView manageBooksPage;
    @FXML
    ImageView searchForBooks;
    @FXML
    ImageView logout;
    @FXML
    Button manageBooks;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookId.setCellValueFactory(new PropertyValueFactory<Book2 , String>("bookID"));
        bookCategory.setCellValueFactory(new PropertyValueFactory<Book2 , String>("bookCategory"));
        bookAuthor.setCellValueFactory(new PropertyValueFactory<Book2 , String>("bookAuthor"));
        bookQuantity.setCellValueFactory(new PropertyValueFactory<Book2 , String>("quantity"));
        bookPrice.setCellValueFactory(new PropertyValueFactory<Book2 , String>("bookPrice"));
       
        
        ObservableList<Book2> list = model.getManger().getBooks();
        table.setItems(list);

        manageBooks.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                SceneController.changeScene(event, "/fxml/manageBooks.fxml", "search result");
                
            }
            
        });

        manageBooksPage.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
            SceneController.changeScene(event, "/fxml/manageBooks.fxml", "search result");
                
                    
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
