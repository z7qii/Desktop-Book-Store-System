import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ChangePasswordController implements Initializable {
    Model model = new Model();
    @FXML
    ImageView viewCart;
    @FXML
    ImageView orderStatus;
    @FXML
    ImageView Home;
    @FXML
    ImageView Logout;
    @FXML
    ImageView history;
    @FXML
    TextField oldPassword;
    @FXML
    TextField newPassword;
    @FXML
    TextField confirmPassword;
    @FXML
    Button save;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        orderStatus.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
              
                
                SceneController.changeScene(event, "/fxml/orderStatus.fxml", "cart");    
                
            }
            
        });

        Logout.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                
                SceneController.changeScene(event, "/fxml/Login.fxml", "cart");    
                
            }
            
        });


        Home.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                
                SceneController.changeScene(event, "/fxml/cusHomePage.fxml", "cart");    
                
            }
            
        });

        viewCart.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
            
                SceneController.changeScene(event, "/fxml/viewCart.fxml", "cart");    
                
            }
            
        });

        

        history.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                SceneController.changeScene(event, "/fxml/history.fxml", "orderHistory");    
            }
            
        });

        
        
        
        save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
              if(!oldPassword.getText().trim().isEmpty() && !newPassword.getText().trim().isEmpty() && !confirmPassword.getText().trim().isEmpty() ){
                if(oldPassword.getText().equals(model.getCustomer().getPassword())){
                    if(newPassword.getText().equals(confirmPassword.getText())){
                        String checkIfValid = isValidPassword(newPassword.getText());
                        if(checkIfValid.equals("valid")){
                            model.getCustomer().changePassword(newPassword.getText(), oldPassword.getText());
                            showAlert("password changed successfully");
                        }else{
                            showAlert(checkIfValid);
                        }
                    }else{
                        showAlert("New password and confirm password does not match");
                    }
                  }
                }else{
                    showAlert("Please fill in all information");
                }
              }
              
            
        });
        
    }

    private String isValidPassword (String password){
        boolean checkValidity = true;
        int passwordLength=8, upChars=0, lowChars=0;
        int special=0, digits=0;
        char ch;
        
        int total = password.length();
        if(total<passwordLength) return "password length must be at least 6 charactrs";
        
        else
        {
           for(int i=0; i<total; i++)
           {
              ch = password.charAt(i);
              if(Character.isUpperCase(ch))
                 upChars = 1;
              else if(Character.isLowerCase(ch))
                 lowChars = 1;
              else if(Character.isDigit(ch))
                 digits = 1;
              else
                 special = 1;
           }
        }
        if(upChars!=1) return "passwrd must contain at least 1 uppercase letter";
        else if(lowChars!=1) return "password must contain at least 1 lowercase leeter";
        else if( digits!=1) return "password must contain at least 1 digit";
        else if(special!=1) return "password msut contain at least 1 special character";
           
        return "valid";
      }

      private void showAlert(String message){
        
       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();

    }
  
    
}
