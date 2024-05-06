import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Library {

    public static String getBookImage(String bookId){
        String bookImage ;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT bookImage FROM  books WHERE bookID = ?");
            preparedStatement.setString(1, bookId);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){
                    bookImage = resultSet.getString("bookImage");
                    return bookImage;
                   
                }
                
            }

            
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return null;
    }




    public static List<Book2> getBooks(){

        List <Book2> books = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM  books");
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
    
    

    public static Book2 getBook(String bookID){
        Book2 book = new Book2();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM  books WHERE bookID = ?");
            preparedStatement.setString(1, bookID);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){
                    book = new Book2(resultSet.getString("bookID"), resultSet.getString("bookName"), resultSet.getString("bookPrice") , resultSet.getString("bookCategory"), resultSet.getString("bookAuthor") ,
                     resultSet.getString("quantity") , resultSet.getString("bookImage"));
                   
                }
                
            }

            
        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return book;
    }

    
    

}
