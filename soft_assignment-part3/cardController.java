import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class cardController  {

    @FXML
    private HBox box;

    @FXML
    private ImageView bookImage;
    @FXML
    private ImageView stars;

    @FXML
    private Label bookName;

    @FXML
    private Label authorName;

    private String [] colors = {"B9E5FF" , "BDB2FE" , "FB9AA8" , "FF5056"};

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
        box.setStyle("-fx-background-color: #"+ colors[(int)(Math.random()*colors.length)] + ";" + 
        " -fx-background-radius: 15;" +
        "-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0,1), 10, 0 , 0 ,10);");

    
    }


}
