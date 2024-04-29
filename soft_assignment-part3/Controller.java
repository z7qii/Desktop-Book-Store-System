import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Controller implements Initializable {
    Model model = new Model();
    @FXML
    ImageView viewCart;
    @FXML
    ImageView orderStatus;
    @FXML
    ImageView history;
    @FXML
    ImageView changePassword;
    @FXML
    ImageView search;
    @FXML
    ImageView logout;
    @FXML
    TextField searchInput;
    ArrayList<Button> addTocart = new ArrayList<>();
    @FXML
    private HBox cardLayoout;
    @FXML
    private GridPane bookContainer;
    private List<Book2> recentlyAdded;
    private List<Book2> recomended;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        viewCart.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
            
                SceneController.changeScene(event, "/fxml/viewCart.fxml", "cart");    
                
            }
            
        });

        orderStatus.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                SceneController.changeScene(event, "/fxml/orderStatus.fxml", "orderStatus");    
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

        logout.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneController.changeScene(event, "/fxml/login.fxml", "Login"); 
            }
            
        });
        
        recentlyAdded = new ArrayList<>(getBooks());
        recomended = new ArrayList<>(getBooks());
        setRecentlyAded();
        setRecomended();
        

        for(int  i  = 0 ; i < addTocart.size() ; i++){
            final int index = i;
                
            addTocart.get(i).setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                   
                    model.getCustomer().addToCart(Library.getBook(addTocart.get(index).getId()));      
                    
                    showAlert("Item added to cart successfully");
                }
                
            });
        }

        search.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(searchInput.getText().trim().isEmpty()){
                    showAlert("Search field is empty");
                }else{
                    model.setSearch(searchInput.getText().toUpperCase());
                    SceneController.changeScene(event, "/fxml/SearchBooks.fxml", "search result");
                }
                    
            }
            
        });

        

      
    }





    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

    private void setRecentlyAded(){
        int column = 0;
        int row = 1;
        try{
            for(Book2 value : recentlyAdded){
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/card.fxml"));
                HBox cardBox = fxmlLoader.load();
                cardController cardController = fxmlLoader.getController();
                cardController.setData(value);
                cardLayoout.getChildren().add(cardBox);
                
            }
    }catch(IOException e){
        e.printStackTrace();
    }
}

private void setRecomended(){
    int column = 0;
    int row = 1;
    try{
        for(Book2 bookk : recomended){
                
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/book.fxml"));
            VBox bookBox = fxmlLoader.load();
            
            BookController BookController = fxmlLoader.getController();
            BookController.setData(bookk);
            
            if(column == 6){
                column = 0;
                ++row;
            }
            Button button = new Button();
            
            button.setId(bookk.getBookID());
            button.setStyle("-fx-background-color: #FF5056;");
            button.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, 16));
            button.setPrefHeight(34);
            button.setPrefWidth(101);
            button.setText("Add to cart");
            bookBox.getChildren().add(button);
            addTocart.add(button);
            bookContainer.add(bookBox,column++,row);
            GridPane.setMargin(bookBox, new Insets(10));
        }
    }catch(IOException e){
        e.printStackTrace();
    }
    
}


    private List<Book2> getBooks(){
        List<Book2> books = new ArrayList<>();
        books = Library.getBooks();
        return books;
    }

   
    
    
}
