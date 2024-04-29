import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BookController {
    @FXML
    private Label authorName;

    @FXML
    private ImageView bookImage;
    @FXML
    private Label bookName;
    @FXML
    private ImageView stars;

    public void setData(Book2 bookk){
        Image image = new Image(getClass().getResourceAsStream(bookk.getBookImage()));
        bookImage.setImage(image);

        bookName.setText(bookk.getBookName());
        
        authorName.setText(bookk.getBookAuthor());
        Integer numOfStars = Integer.parseInt( bookk.getbookRating());
        if(numOfStars == 1){
            Image img = new Image(getClass().getResourceAsStream("/images/oneStar.png"));
            stars.setImage(img);
        }else if(numOfStars == 2){
            Image img = new Image(getClass().getResourceAsStream("/images/twoStar.png"));
            stars.setImage(img);
        }else if(numOfStars == 3){
            Image img = new Image(getClass().getResourceAsStream("/images/threeStar.png"));
            stars.setImage(img);
        }else if(numOfStars == 4){
            Image img = new Image(getClass().getResourceAsStream("/images/fourStar.png"));
            stars.setImage(img);
        }else if(numOfStars == 5){
            Image img = new Image(getClass().getResourceAsStream("/images/fiveStar.png"));
            stars.setImage(img);
        }
        
        
    }

    
}
