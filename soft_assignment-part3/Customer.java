import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.SourceDataLine;

public class Customer extends User {
    
     private Address address ;
    private Cart cart;
    private List<Order> orders;
    
    public Customer(String Fname , String LName, String email , String password){
        super(Fname , LName , email , password);
    }
    public Customer() {
        
    }

    public boolean login(){
        return super.login("customers");
        
    }


    

    public boolean signup(){
        Boolean excepted = false;
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("URL");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM customers WHERE email = ?");
            psCheckUserExists.setString(1, super.getEmail());
            resultSet = psCheckUserExists.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                excepted = true;
                psInsert = connection.prepareStatement("INSERT INTO customers(fname, lname , email, password) VALUES (?, ? , ?, ?)");
                psInsert.setString(1, super.getFName());
                psInsert.setString(2, super.getLName());
                psInsert.setString(3, super.getEmail());
                psInsert.setString(4, super.getPassword());
                psInsert.executeUpdate();
            } else {
                
            }
            
        } catch (SQLException e) {

            e.printStackTrace();
            

        } finally {

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};    
            try { if (psCheckUserExists != null) psCheckUserExists.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (psInsert != null) psInsert.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};
        }

        return excepted;
    }

    public List<Book2> searchBooks(String search){
        List <Book2> books = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE bookName = ? OR bookCategory = ? OR bookAuthor = ? ");
            preparedStatement.setString(1, search);
            preparedStatement.setString(2, search);
            preparedStatement.setString(3, search);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){
                    Book2 book = new Book2(resultSet.getString("bookID"), resultSet.getString("bookName"), resultSet.getString("bookPrice") , resultSet.getString("bookCategory"), resultSet.getString("bookAuthor") ,
                     resultSet.getString("quantity") , resultSet.getString("bookImage") , resultSet.getString("bookRating"));
                    books.add(book);
                }
                
            }

            
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return books;
    }


    public ArrayList<Cart> getCart(){
        ArrayList <Cart> cart = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM Cart WHERE cusEmail = ?");
            preparedStatement.setString(1, super.getEmail());
           
            resultSet = preparedStatement.executeQuery();
            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){

                    Cart item = new Cart(resultSet.getString("cusEmail") , resultSet.getString("bookID") , resultSet.getString("bookName") , resultSet.getString("Price"),
                    resultSet.getString("bookImage") , resultSet.getString("bookQuantity"));
                    cart.add(item);
                }
                
            }

            
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return cart;
    }

    public void updateCart(ArrayList <Cart> cart){
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            deletCart();
            connection = DriverManager.getConnection("URL");
            
            
            for(int i = 0 ; i < cart.size() ; i++){
                preparedStatement = connection.prepareStatement("INSERT INTO cart(cusEmail , bookID , bookName , Price , bookImage , bookQuantity) VALUES (?, ? , ? , ? , ? , ?)");
                preparedStatement.setString(1, super.getEmail());
                preparedStatement.setString(2, cart.get(i).getBookId());
                preparedStatement.setString(3, cart.get(i).getBookName());
                preparedStatement.setString(4, cart.get(i).getPrice());
                preparedStatement.setString(5, cart.get(i).getBookImage());
                preparedStatement.setString(6, cart.get(i).getBookQuantity());
                

                preparedStatement.executeUpdate();

            }
            
    
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        
    }
    public boolean addToCart(Book2 book){
       
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT quantity FROM books WHERE bookID = ?");
            preparedStatement.setString(1, book.getBookID());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getInt(1) >= 0){
                    preparedStatement = connection.prepareStatement("INSERT INTO cart(cusEmail , bookID , bookName , Price , bookImage , bookQuantity) VALUES (?, ? , ? , ? , ? , ?)");
                    preparedStatement.setString(1, super.getEmail());
                    preparedStatement.setString(2, book.getBookID());
                    preparedStatement.setString(3, book.getBookName());
                    preparedStatement.setString(4, book.getBookPrice());
                    preparedStatement.setString(5, book.getBookImage());
                    preparedStatement.setString(6, "1");
                    

                    preparedStatement.executeUpdate();
                    return true;
                }
            }

            
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return false;
    }


    

   

   
    public boolean changePassword(String newPassword , String oldPassword){
        if(newPassword.equals(super.getPassword())) return false;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("UPDATE customers SET password = ? WHERE password = ? ");
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2 , oldPassword);
            preparedStatement.executeUpdate();
            super.setPassword(newPassword);

        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return true;
    }

    public void deletCart(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("DELETE FROM cart WHERE cusEmail = ?");
            preparedStatement.setString(1, super.getEmail());
            preparedStatement.executeUpdate();
            
    
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        
    }

    public void Order(ArrayList<Cart> books , String paymentType){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        

        try{
            Random rand = new Random();
            Integer id;
            connection = DriverManager.getConnection("URL");
            
            
            for(int i = 0 ; i < books.size() ; i++){
                id = rand.nextInt(1000);
                preparedStatement = connection.prepareStatement("INSERT INTO orders(orderID , bookID, bookName , customerEmail , quantity ,  orderTotal , paymentType , orderStatus) VALUES (?, ? , ? , ? , ? , ? , ? , ?)");

                preparedStatement.setString(1, id.toString());
                preparedStatement.setString(2, books.get(i).getBookId());
                preparedStatement.setString(3, books.get(i).getBookName());
                preparedStatement.setString(4, super.getEmail());
                preparedStatement.setString(5, books.get(i).getBookQuantity());
                preparedStatement.setString(6 , books.get(i).getPrice());
                preparedStatement.setString(7, paymentType);
                preparedStatement.setString(8, "in Progress");
                preparedStatement.executeUpdate();
            }
            
           
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};
        }
    }

    public ArrayList<Order> getOrderStatus(){
        return OrderStatusAndHistoryHelper("in progress");
    }

    public ArrayList<Order> getOrderHistory(){
        return OrderStatusAndHistoryHelper("approved");
    }

     private ArrayList <Order> OrderStatusAndHistoryHelper(String orderStatus){
        ArrayList <Order> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        

        try{
           
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE customerEmail = ? AND orderStatus = ?");

            preparedStatement.setString(1, super.getEmail());
            preparedStatement.setString(2, orderStatus);
            
            resultSet = preparedStatement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                while(resultSet.next()){
                    orders.add(new Order(resultSet.getString("orderID"), resultSet.getString("bookID"), resultSet.getString("bookID") , resultSet.getString("customerEmail"),
                    resultSet.getString("quantity") ,  Double.parseDouble(resultSet.getString("orderTotal")) ,
                        resultSet.getString("paymentType"), resultSet.getString("orderStatus")));
                }
            }
            
           
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};
        }

        return orders;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
        setAddress();
    }
    private void setAddress() {
       
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("URL");
            psCheckUserExists = connection.prepareStatement("INSERT INTO address (cusEmail, city , street , postalCode) VALUES (? , ? , ? , ?)");
            psCheckUserExists.setString(1, super.getEmail());
            psCheckUserExists.setString(2, address.getCity());
            psCheckUserExists.setString(3, address.getStreet());
            psCheckUserExists.setString(4, address.getPostalCode());

            psCheckUserExists.executeUpdate();

            
        } catch (SQLException e) {

            e.printStackTrace();
            

        } finally {

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};    
            try { if (psCheckUserExists != null) psCheckUserExists.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (psInsert != null) psInsert.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};
        } 

    }

    public boolean checkIfAddressSet(){
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM address WHERE cusEmail = ?");
            preparedStatement.setString(1, super.getEmail());
            resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                return true;
                
            }
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return false;
    }

    
}
