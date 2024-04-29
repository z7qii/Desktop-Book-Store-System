import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
    Model model = new Model();
    @FXML
    private Button button_login;

    @FXML
    private Button button_sign_up;

    @FXML
    private TextField tf_email;

    @FXML
    private PasswordField tf_password ;
    @FXML
    private Label notUser;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        button_login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                boolean loggedIn;
                if(tf_email.getText().contains("@employee.com")){
                    Employee employee = new Employee();
                    employee.setEmail(tf_email.getText());
                    employee.setPassword(tf_password.getText());
                    loggedIn = employee.login();

                    if(loggedIn){
                        model.setEmployee(employee);
                        
                        SceneController.changeScene(event, "/fxml/Approve&newOrders.fxml", "Home page" );
                    }

                }else if(tf_email.getText().contains("@manager.com")){
                    Manager manager = new Manager();
                    manager.setEmail(tf_email.getText());
                    manager.setPassword(tf_password.getText());
                    loggedIn = manager.login();

                    if(loggedIn){
                        model.setManager(manager);
                        
                        SceneController.changeScene(event, "/fxml/viewEmployees.fxml", "Home page" );
                    }
                }else if(tf_email.getText().contains("@administrator.com")){
                    Administrator administrator = new Administrator();
                    administrator.setEmail(tf_email.getText());
                    administrator.setPassword(tf_password.getText());
                    loggedIn = administrator.login();

                    if(loggedIn){
                        model.setAdministrator(administrator);
                        
                        SceneController.changeScene(event, "/fxml/viewManagers.fxml", "Home page" );
                    }
                }
                
                else{

                    Customer customer = new Customer() ;
                    customer.setEmail(tf_email.getText());
                    customer.setPassword(tf_password.getText());
                    loggedIn = customer.login();
                    model.setCustomer(customer);
                    
                    if(loggedIn){
                        
                        SceneController.changeScene(event, "/fxml/cusHomePage.fxml", "Home page" );
                    }
                    
                }
                    
                
                
                if(!loggedIn){
                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("The provided credentials are incorrect !");
                    alert.show();
                }
                
                
            }
            
        });

        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                SceneController.changeScene(event, "/fxml/signup.fxml", "Sign Up");
                
            }
            
        });
        
    }

    

    
}
