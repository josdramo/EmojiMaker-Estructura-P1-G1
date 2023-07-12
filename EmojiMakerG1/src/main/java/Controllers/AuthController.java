/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Comparators.ProfileComparator;
import Comparators.UserComparator;
import Datos.LeerArchivos;
import Enums.EmojiComponentType;
import Modelos.Profile;
import Modelos.Usuario;
import TDAS.ListaCircularDoble;
import com.pooespol.emojimakerg1.App;
import java.util.HashMap;
import java.util.Map;
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

            TreeSet<Profile> perfiles = new TreeSet(new ProfileComparator());
            
            perfiles.addAll(App.perfiles);

            Boolean authSuccess = perfiles.contains(new Profile(usuario));
            
            if (authSuccess) {
                Profile perfil = null;
                
                for (Profile p : perfiles) {
                    UserComparator userComparator = new UserComparator();
                    
                    if (userComparator.compare(usuario, p.getUsuario()) == 0) {
                        perfil = p;
                    }
                }
                
                if (perfil != null) {
                    app.createSession(perfil);
                }
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
            Boolean alreadyRegistered = App.perfiles.contains(new Profile(usuario));

            if (alreadyRegistered) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Nombre de usuario ocupado.");
                alert.showAndWait();
            }

            if (!alreadyRegistered) {
                Map<EmojiComponentType, ListaCircularDoble<String>> componentes = new HashMap();
                
                componentes.put(EmojiComponentType.FACE, LeerArchivos.listaR());
                componentes.put(EmojiComponentType.MIRADA, LeerArchivos.listaO());
                componentes.put(EmojiComponentType.MOUTH, LeerArchivos.listaB());
                
                Profile profile = new Profile(usuario, componentes);
                
                App.perfiles.add(profile);
                
                app.createSession(profile);
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
