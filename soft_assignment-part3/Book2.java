public class Book2 {
    private String bookID;
    private String bookName;
    private String bookPrice;
    private String bookCategory;
    private String bookAuthor;
    private String quantity;
    private String bookImage;
    private String bookRating;
    
   
    public Book2(String bookID, String bookName, String bookPrice, String bookCategory, String bookAuthor , String quantity,  String bookImage) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookCategory = bookCategory;
        this.bookAuthor = bookAuthor;
        this.quantity = quantity;
        this.bookImage = bookImage;
    }

    public Book2(String bookID, String bookName, String bookPrice, String bookCategory, String bookAuthor , String quantity,  String bookImage , String bookRating) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookCategory = bookCategory;
        this.bookAuthor = bookAuthor;
        this.quantity = quantity;
        this.bookImage = bookImage;
        this.bookRating = bookRating;
    }
    public Book2() {}

    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }
    
    public String getBookID() {
        return bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookPrice() {
        return bookPrice;
    }
    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }
    public String getBookCategory() {
        return bookCategory;
    }
    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookImage(){
        return bookImage;
    }

    public void setBookRating(String bookRating){
        this.bookRating = bookRating;
    }

    public String getbookRating(){
        return bookRating;
    }

    

    
}
