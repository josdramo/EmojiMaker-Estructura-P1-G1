/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import com.pooespol.emojimakerg1.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author infrative
 */
public class AuthController {
    App app;
    
    @FXML
    private VBox container;
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField passwordField;
    
    public void initialize() {
        System.out.println("Hosss");
    }
    
    public void onLogin() {
        
        // TODO: Verificar credenciales
        //app.switchToMenuPrincipal();
        
        String nombre = usernameField.getText();
        String pass = passwordField.getText();
        
        
    }
    
    public void onRegister() {
        
    }

    public void setApp(App app) {
        this.app = app;
    }
    
    
}
