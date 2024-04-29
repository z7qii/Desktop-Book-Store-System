import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemInCart {
    private String bookId;
    private Button inc;
    private Button dic;
    private Button remove;
    private Label price;
    private Label quant;
    private String bookName;
    
    public ItemInCart(Button inc, Button dic, Button remove, Label price, Label quant) {
        this.inc = inc;
        this.dic = dic;
        this.remove = remove;
        this.price = price;
        this.quant = quant;
    }
    

    public ItemInCart() {
    }
    public String getBookId(){
        return bookId;
    }
    public Button getInc() {
        return inc;
    }
    public Button getDic() {
        return dic;
    }
    public Button getRemove() {
        return remove;
    }
    public Label getPrice() {
        return price;
    }
    public Label getQuant() {
        return quant;
    }
    public void setInc(Button inc) {
        this.inc = inc;
    }
    public void setDic(Button dic) {
        this.dic = dic;
    }
    public void setRemove(Button remove) {
        this.remove = remove;
    }
    public void setPrice(Label price) {
        this.price = price;
    }
    public void setQuant(Label quant) {
        this.quant = quant;
    }

    public void setBookId(String bookID){
        this.bookId = bookID;
    }


    public String getBookName() {
        return bookName;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    

    
}
