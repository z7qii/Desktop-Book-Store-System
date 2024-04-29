import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class manageBooksController implements Initializable{
    Model model = new Model();
    @FXML
    TextField aBookId;
    @FXML
    TextField dBookId;
    @FXML
    TextField bookName;
    @FXML
    TextField bookImage;
    @FXML
    TextField category;
    @FXML
    TextField author;
    @FXML
    TextField price;
    @FXML
    TextField quantity;
    @FXML
    TextField bookRating;
    @FXML
    Button addBook;
    @FXML
    Button deleteBook;
    @FXML
    ImageView viewEmployees;
    @FXML
    ImageView checkOrders;
    @FXML
    ImageView searchForBooks;
    @FXML
    ImageView logout;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        deleteBook.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                model.getManger().deleteBook(dBookId.getText());
            }
            
        });

        addBook.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                
                Book2 book = new Book2(aBookId.getText() , bookName.getText() , price.getText() ,
                category.getText() , author.getText() , quantity.getText() , bookImage.getText() , bookRating.getText());
                model.getManger().addBook(book);

                
                
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
