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
public class AuthController extends Controller {
    @FXML
    private VBox container;
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField passwordField;
    
    public void onLogin() {       
        String nombre = usernameField.getText();
        String pass = passwordField.getText();
        
        if (!hasEmptyCredentials(nombre, pass)) {
            Usuario usuario = new Usuario(nombre, pass);

            TreeSet<Profile> perfiles = new TreeSet(new ProfileComparator());
            
            perfiles.addAll(App.perfiles);

            Boolean authSuccess = perfiles.contains(new Profile(usuario));
            
            if (authSuccess) {
                for (Profile perfil : perfiles) {
                    UserComparator userComparator = new UserComparator();
                    
                    if (userComparator.compare(usuario, perfil.getUsuario()) == 0) {
                        this.getApp().createSession(perfil);
                        break;
                    }
                }
            }

            if (!authSuccess) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Credenciales incorrectas.");
                alert.showAndWait();
            }
        }
        
        else {
            showEmptyCredentialsAlert();
        }
    }
    
    public void showEmptyCredentialsAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("No intentes pasarte de listo.");
        alert.showAndWait();
    }

    private boolean hasEmptyCredentials(String nombre, String pass) {
        return nombre.isBlank() || pass.isBlank();
    }
    
    public void onRegister() {
        String nombre = usernameField.getText();
        String pass = passwordField.getText();
        
        if (!hasEmptyCredentials(nombre, pass)) {
            Usuario usuario = new Usuario(nombre, pass);
            Boolean alreadyRegistered = App.perfiles.contains(new Profile(usuario));

            if (alreadyRegistered) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Nombre de usuario ocupado.");
                alert.showAndWait();
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
                
                this.getApp().createSession(profile);
            }
        }
        
        else {
            showEmptyCredentialsAlert();
        }
    }
    
    
}
