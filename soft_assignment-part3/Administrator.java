import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Administrator extends User {
    
    private int id;
    private String nationality;
    private String gender;
    private String tel;
    private String dob;

    public boolean login(){
        return super.login("administrators");
    }


    public ObservableList<Manager> viewManagers(){

        ObservableList<Manager> managers = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/software_assignment", "root", "uvhrkh12");
            preparedStatement = connection.prepareStatement("SELECT * FROM managers" );
        
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                managers.add(new Manager(resultSet.getString("id") , resultSet.getString("fName") , resultSet.getString("lName"), resultSet.getString("email"), resultSet.getString("password") , resultSet.getString("nationality"),
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

        return managers;
        
    }

    public Double viewSales(){
        Double sales = 0.0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/software_assignment", "root", "uvhrkh12");
            preparedStatement = connection.prepareStatement("SELECT orderTotal FROM orders");
            
            resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){
                    String orderTotal = resultSet.getString("orderTotal");
                    sales +=  Double.parseDouble(orderTotal);
                    
                }
                
            }

        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return sales;
    }


    
}
