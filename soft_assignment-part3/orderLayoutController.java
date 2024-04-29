import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class orderLayoutController {
   
    @FXML
    Label price;
    @FXML
    ImageView bookImage;
    @FXML
    Label bookName;
    @FXML
    Label quntity;

    
    public void setData(Order order){
        
        
        
        price.setText(order.getTotal().toString());
        bookName.setText(order.getBookName());
        quntity.setText(order.getQuantity());
        
        Image image = new Image(getClass().getResourceAsStream(Library.getBookImage(order.getBookId())));
        bookImage.setImage(image);
        
       
    }

}
