
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ViewCartController implements Initializable {
    
    @FXML
    ImageView Home;
    @FXML
    ImageView Logout;
    @FXML
    ImageView orderStatus;
    @FXML
    ImageView history;
    @FXML
    ImageView changePassword;
    @FXML
    Button checkout;
    @FXML
    VBox cartContainer;
    @FXML
    Label totalPrice;
    Integer totlPrice = 0;
    @FXML
    ArrayList<ItemInCart> items = new ArrayList<>();
    Model model = new Model();
    ArrayList <Cart> cart = model.getCustomer().getCart();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        
        setCart();
        Home.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                model.setTotalPrice(totlPrice);
                model.setCart(cart);
                updateCart();
                
                SceneController.changeScene(event, "/fxml/cusHomePage.fxml", "cart");    
                
            }
            
        });


        orderStatus.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                model.setTotalPrice(totlPrice);
                model.setCart(cart);
                updateCart();
                
                SceneController.changeScene(event, "/fxml/orderStatus.fxml", "cart");    
                
            }
            
        });

        history.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                model.setTotalPrice(totlPrice);
                model.setCart(cart);
                updateCart();
                
                SceneController.changeScene(event, "/fxml/history.fxml", "cart");    
                
            }
            
        });

        changePassword.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                model.setTotalPrice(totlPrice);
                model.setCart(cart);
                updateCart();
                
                SceneController.changeScene(event, "/fxml/changePassword.fxml", "cart");    
                
            }
            
        });
        


        for(int  i  = 0 ; i < items.size() ; i++){
            final int index = i;
                
            items.get(i).getInc().setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    increaseQuantity(items.get(index));
                }
                
            });
        }


        for(int  i  = 0 ; i < items.size() ; i++){
            final int index = i;
                
            items.get(i).getDic().setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    
                    dicreaseQuantity(items.get(index));
                }
                
            });
        }

        Logout.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                model.setTotalPrice(totlPrice);
                model.setCart(cart);
                updateCart();
                
                SceneController.changeScene(event, "/fxml/Login.fxml", "cart");    
                
            }
            
        });



        for(int  i  = 0 ; i < items.size() ; i++){
            final int index = i;
                
            items.get(i).getRemove().setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    remove(items.get(index));
                    
                }
                
            });
        }

        checkout.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                model.setTotalPrice(totlPrice);
                model.setCart(cart);
                updateCart();
                SceneController.changeScene(event, "/fxml/payment.fxml", "PAYMENT");
                
            }
            
        });
        
    }





    public void setCart(){
        try{
            for(int i = 0 ; i < cart.size() ; i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/item.fxml"));
                AnchorPane anch;
                anch = fxmlLoader.load();
                ItemLayoutController item = fxmlLoader.getController();
                ItemInCart itemInCart = item.setData(cart.get(i));
                totlPrice += Integer.parseInt(itemInCart.getPrice().getText().replaceAll("\\s", ""));
                items.add(itemInCart);
                cartContainer.getChildren().add(anch);
                
            }

            totalPrice.setText("RM" + totlPrice.toString());
        }catch (IOException e) {
            
            e.printStackTrace();
        }

    }

    public void remove(ItemInCart item){

            Integer quantity = Integer.parseInt(item.getQuant().getText().replaceAll("\\s", ""));
            Integer price = Integer.parseInt(item.getPrice().getText().replaceAll("\\s", ""));
            totlPrice -= price ;
            price = 0;
            quantity = 0 ;
            item.getQuant().setText(quantity.toString());
            item.getPrice().setText(price.toString());
            totalPrice.setText("RM" + totlPrice.toString());

    }


    public void increaseQuantity(ItemInCart item){

            int helper;
            Integer quantity = Integer.parseInt(item.getQuant().getText().replaceAll("\\s", ""));
            Integer price = Integer.parseInt(item.getPrice().getText().replaceAll("\\s", ""));

            if(quantity == 0){
                            
                helper = getBookPrice(item.getBookId());
                System.out.println(helper);

            }else{

                helper = price / quantity; 
            }
                        
            price += helper;
            totlPrice += helper;
            quantity++;
            totalPrice.setText("RM" + totlPrice.toString());
            item.getQuant().setText(quantity.toString());
            item.getPrice().setText(price.toString());
                        
    }


    public void dicreaseQuantity(ItemInCart item){

            Integer quantity = Integer.parseInt(item.getQuant().getText().replaceAll("\\s", ""));
            Integer price = Integer.parseInt(item.getPrice().getText().replaceAll("\\s", ""));
            if(quantity != 0){
                int helper = price / quantity; 
                price -= helper;
                totlPrice -= helper;
                quantity--;
                totalPrice.setText("RM" + totlPrice.toString());
                item.getQuant().setText(quantity.toString());
                item.getPrice().setText(price.toString());
            }
                   
    }


    public int getBookPrice(String bookID){
        for(int i = 0 ; i < cart.size() ; i++ )
            if(cart.get(i).getBookId().equals(bookID))
                return Integer.parseInt(cart.get(i).getPrice());
        

        return Integer.parseInt("0");
    }

    public void updateCart(){
        for(int i = 0 ; i < items.size() ; i++){
            ItemInCart item = items.get(i);
            if(!item.getQuant().getText().replaceAll("\\s", "").equals("0")){
                for(int j = 0 ; j < cart.size() ; j++){
                    if(cart.get(j).getBookId().equals(item.getBookId())){
                        cart.get(j).setPrice(item.getPrice().getText().replaceAll("\\s", ""));
                        cart.get(j).setBookQuantity(item.getQuant().getText().replaceAll("\\s", ""));
                        System.out.println(item.getQuant().getText().replaceAll("\\s", ""));
                        
                    }
                        
                }
            }else{
                for(int j = 0 ; j < cart.size() ; j++ ){
                    if(cart.get(j).getBookId().equals(item.getBookId())){
                        cart.remove(j);
                    }
                }
                
            }
            
        }

        model.getCustomer().updateCart(cart);
    }
    
    
}
