import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Employee extends User {
    
    private String id;
    private String nationality;
    private String gender;
    private String tel;
    private String dob;

    


    

   
    public Employee(){}
    public Employee(String id, String fName, String lName, String email, String password, String nationality,
            String gender, String tel, String dob) {
        super(fName, lName, email, password);
        this.id = id;
        this.nationality = nationality;
        this.gender = gender;
        this.tel = tel;
        this.dob = dob;
    }

    

    public boolean login(){
        return super.login("employees");
    }
    public ObservableList<Order> getNewOrders(){

        ObservableList<Order> orders = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/software_assignment", "root", "uvhrkh12");
            preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE orderStatus = ?" );
            preparedStatement.setString(1, "in progress");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                orders.add(new Order(resultSet.getString("orderID") , resultSet.getString("bookId"), resultSet.getString("bookName"),
                 resultSet.getString("customerEmail"),resultSet.getString("quantity"), Double.parseDouble(resultSet.getString("orderTotal")) , resultSet.getString("paymentType"),
                resultSet.getString("orderStatus")));
                
            }

            if (preparedStatement != null) preparedStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};    
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};
           
            
        }

        return orders;
        
    }


    public void approveOrder(String orderId){
       
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/software_assignment", "root", "uvhrkh12");
            preparedStatement = connection.prepareStatement("update orders SET orderStatus = ? where orderID = ?");
            preparedStatement.setString(1, "approved");
            preparedStatement.setString(2, orderId);
            preparedStatement.executeUpdate();
            // if(resultSet.isBeforeFirst()){
            //     return true;
            // }
           
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
