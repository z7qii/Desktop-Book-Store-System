import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String cusEmail;
    private String bookId;
    private String bookName;
    private String bookImage;
    private String Price;
    private String bookQuantity;
    
    

    public Cart(String cusEmail , String bookId, String bookName, String Price , String bookImage , String bookQuantity) {
        this.cusEmail = cusEmail;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.Price = Price;
        this.bookQuantity = bookQuantity;
    }

    

    public String getCusEmail() {
        return cusEmail;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookImage() {
        return bookImage;
    }

    public String getPrice() {
        return Price;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(String bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    
}
