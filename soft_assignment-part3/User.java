import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class User {
    private String FName ;
    private String LName ;
    private String email;
    private String password;

    
    public User() {
    }


    public User(String fName, String lName, String email, String password) {
        FName = fName;
        LName = lName;
        this.email = email;
        this.password = password;
    }

    public boolean login(String userType){
        Boolean logedIn = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM " + userType + " WHERE email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){
                    String retrievedPassword = resultSet.getString("password");
                    if(retrievedPassword.equals(this.password)){
                        logedIn = true;
                        this.FName = resultSet.getString("fName");
                        this.LName = resultSet.getString("lName");
                        
                    }
                }
                
            }

        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return logedIn;
    }


    

    public String getFName() {
        return FName;
    }


    public String getLName() {
        return LName;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }

    public void setFName(String fName) {
        FName = fName;
    }


    public void setLName(String lName) {
        LName = lName;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    
}
