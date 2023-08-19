/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Comparators.ProfileComparator;
import Comparators.UserComparator;
import Datos.LeerArchivos;
import Enums.EmojiComponentType;
import Modelos.Emoticon;
import Modelos.Profile;
import Modelos.Usuario;
import TDAS.CircularList;
import com.app.App;
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
                showEmptyCredentialsAlert("Credenciales incorrectas.");
            }
        }
        
        if (emptyCredentials) {
            showEmptyCredentialsAlert("No intentes pasarte de listo.");
        }
    }
    
    public void showEmptyCredentialsAlert(String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(texto);
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
                showEmptyCredentialsAlert("Nombre de usuario ocupado.");
            }

            if (!alreadyRegistered) {
                Map<EmojiComponentType, CircularList<String>> componentes = new HashMap();
                
                componentes.put(EmojiComponentType.FACE, LeerArchivos.listaR());
                componentes.put(EmojiComponentType.MIRADA, LeerArchivos.listaO());
                componentes.put(EmojiComponentType.MOUTH, LeerArchivos.listaB());
                
                Emoticon emoticonUno = new Emoticon();
                
                emoticonUno.updateComponent(EmojiComponentType.FACE, componentes.get(EmojiComponentType.FACE).get(1));
                emoticonUno.updateComponent(EmojiComponentType.MIRADA, componentes.get(EmojiComponentType.MIRADA).get(3));
                emoticonUno.updateComponent(EmojiComponentType.MOUTH, componentes.get(EmojiComponentType.MOUTH).get(0));
                
                Profile profile = new Profile(usuario, componentes);
                
                profile.getEmoticones().add(emoticonUno);
                
                App.perfiles.add(profile);
                
                app.createSession(profile);
            }
        }
        
        if (emptyCredentials) {
            showEmptyCredentialsAlert("No intentes pasarte de listo.");
        }
    }

    public void setApp(App app) {
        this.app = app;
    }
    
    
}
