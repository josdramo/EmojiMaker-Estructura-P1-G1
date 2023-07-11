/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Comparators.UserComparator;
import Modelos.Usuario;
import com.pooespol.emojimakerg1.App;
import java.util.TreeSet;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    
    public void onLogin() {       
        String nombre = usernameField.getText();
        String pass = passwordField.getText();
        
        Boolean emptyCredentials = nombre.isBlank() || pass.isBlank();
        
        if (!emptyCredentials) {
            Usuario usuario = new Usuario(nombre, pass);

            TreeSet<Usuario> usuarios = new TreeSet(new UserComparator());
            usuarios.addAll(App.usuarios);

            Boolean authSuccess = usuarios.contains(usuario);

            if (authSuccess) {
                app.createSession(usuario);
            }

            if (!authSuccess) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Credenciales incorrectas.");
                alert.showAndWait();
            }
        }
        
        if (emptyCredentials) {
            showEmptyCredentialsAlert();
        }
    }
    
    public void showEmptyCredentialsAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("No intentes pasarte de listo.");
        alert.showAndWait();
    }
    
    public void onRegister() {
        String nombre = usernameField.getText();
        String pass = passwordField.getText();
        
        Boolean emptyCredentials = nombre.isBlank() || pass.isBlank();
        
        if (!emptyCredentials) {
            Usuario usuario = new Usuario(nombre, pass);
            Boolean alreadyRegistered = App.usuarios.contains(usuario);

            if (alreadyRegistered) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Nombre de usuario ocupado.");
                alert.showAndWait();
            }

            if (!alreadyRegistered) {
                App.usuarios.add(usuario);
                app.createSession(usuario);
            }
        }
        
        if (emptyCredentials) {
            showEmptyCredentialsAlert();
        }
    }

    public void setApp(App app) {
        this.app = app;
    }
    
    
}
