import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Manager extends User {
    private String id;
    private String nationality;
    private String gender;
    private String tel;
    private String dob;

    

    public Manager(){}

    public boolean login(){
        return super.login("managers");
    }
    public Manager(String id, String fName, String lName, String email, String password, String nationality,
            String gender, String tel, String dob) {
        super(fName, lName, email, password);
        this.id = id;
        this.nationality = nationality;
        this.gender = gender;
        this.tel = tel;
        this.dob = dob;
    }
   
    public void addBook(Book2 book){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
           
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("INSERT INTO books (bookID , bookName , bookPrice , bookCategory , bookAuthor , quantity , bookImage , bookRating) VALUES (? , ? , ? , ? , ? , ? , ? , ? )");
            preparedStatement.setString(1, book.getBookID());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setString(3, book.getBookPrice());
            preparedStatement.setString(4, book.getBookCategory());
            preparedStatement.setString(5, book.getBookAuthor());
            preparedStatement.setString(6, book.getQuantity());
            preparedStatement.setString(7, book.getBookImage());
            preparedStatement.setString(8, book.getbookRating());

            
            
            preparedStatement.executeUpdate();
            
            
           
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

           
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};
        }

       
    }

    public ObservableList<Order> getOrders(){
        
        ObservableList<Order> orders = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        

        try{
           
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM orders");

            
            
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

    public ObservableList<Employee> viewEmployees(){

        ObservableList<Employee> employees = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM employees" );
        
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                employees.add(new Employee(resultSet.getString("id") , resultSet.getString("fName") , resultSet.getString("lName"), resultSet.getString("email"), resultSet.getString("password") , resultSet.getString("nationality"),
                resultSet.getString("gender") , resultSet.getString("tel") , resultSet.getString("dob")));
                
            }

            if (preparedStatement != null) preparedStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};    
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};
           
            
        }

        return employees;
        
    }

    public ObservableList<Book2> getBooks(){
        ObservableList<Book2> books = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM books" );
        
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Book2 book = new Book2(resultSet.getString("bookID"), resultSet.getString("bookName"), resultSet.getString("bookPrice") , resultSet.getString("bookCategory"), resultSet.getString("bookAuthor") ,
                resultSet.getString("quantity") , resultSet.getString("bookImage"));
               books.add(book);
                
            }

            if (preparedStatement != null) preparedStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};    
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};
           
            
        }

        return books;
        
    }

    public void deleteBook(String bookID){
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("DELETE FROM  books WHERE bookID = ?");
            preparedStatement.setString(1, bookID);
            preparedStatement.executeUpdate();
            
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

       
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

}
