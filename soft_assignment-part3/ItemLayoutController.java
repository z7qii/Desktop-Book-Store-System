import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemLayoutController  {
    @FXML
    Button increaseQunt;
    @FXML
    Button dicreaseQunt;
    @FXML
    Button remove;
    @FXML
    Label price;
    @FXML
    ImageView bookImage;
    @FXML
    Label bookName;
    @FXML
    Label quntity;

    
    public ItemInCart setData(Cart cart){
        ItemInCart item = new ItemInCart();
        
        quntity.setId(cart.getBookId());
        increaseQunt.setId(cart.getBookId());
        dicreaseQunt.setId(cart.getBookId());
        remove.setId(cart.getBookId());
        price.setText(cart.getPrice());
        bookName.setText(cart.getBookName());
        quntity.setText(cart.getBookQuantity());
        
        item.setBookId(cart.getBookId());
        item.setInc(increaseQunt);
        item.setDic(dicreaseQunt);
        item.setRemove(remove);
        item.setQuant(quntity);
        item.setPrice(price);
        item.setBookName(cart.getBookName());
        Image image = new Image(getClass().getResourceAsStream(cart.getBookImage()));
        bookImage.setImage(image);
        
        return item;
    }

}
