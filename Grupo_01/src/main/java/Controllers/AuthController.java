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
        
        if (hasEmptyCredentials(nombre, pass)) {
            showAlert("Error", "No intentes pasarte de listo.");
            return;
        }

        if (authenticate(nombre, pass)) {
            return;
        }

        showAlert("Error", "Credenciales incorrectas.");
    }
    
    private boolean authenticate(String nombre, String pass) {
        Usuario usuario = new Usuario(nombre, pass);

        TreeSet<Profile> perfiles = new TreeSet<>(new ProfileComparator());
        perfiles.addAll(App.perfiles);

        // Comprueba existencia
        Profile lookup = new Profile(usuario);
        if (!perfiles.contains(lookup)) {
            return false;
        }

        // Busca el perfil exacto y crea sesión
        for (Profile perfil : perfiles) {
            if (new UserComparator().compare(usuario, perfil.getUsuario()) == 0) {
                getApp().createSession(perfil);
                return true;
            }
        }
        return false;
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

        if (hasEmptyCredentials(nombre, pass)) {
            showAlert("Error", "No intentes pasarte de listo.");
            return;
        }

        Profile nuevo = buildNewProfile(nombre, pass);
        if (App.perfiles.contains(nuevo)) {
            showAlert("Error", "Nombre de usuario ocupado.");
        } else {
            App.perfiles.add(nuevo);
            getApp().createSession(nuevo);
        }
    }
    
    private Profile buildNewProfile(String nombre, String pass) {
        Usuario usuario = new Usuario(nombre, pass);
        Map<EmojiComponentType, CircularList<String>> componentes = new HashMap<>();
        componentes.put(EmojiComponentType.FACE, LeerArchivos.listaR());
        componentes.put(EmojiComponentType.MIRADA, LeerArchivos.listaO());
        componentes.put(EmojiComponentType.MOUTH, LeerArchivos.listaB());

        // Emoticon inicial
        Emoticon emoticon = new Emoticon();
        emoticon.updateComponent(EmojiComponentType.FACE, componentes.get(EmojiComponentType.FACE).get(1));
        emoticon.updateComponent(EmojiComponentType.MIRADA, componentes.get(EmojiComponentType.MIRADA).get(3));
        emoticon.updateComponent(EmojiComponentType.MOUTH, componentes.get(EmojiComponentType.MOUTH).get(0));

        Profile profile = new Profile(usuario, componentes);
        profile.getEmoticones().add(emoticon);
        return profile;
    }

    private boolean hasEmptyCredentials(String nombre, String pass) {
        return nombre.isBlank() || pass.isBlank();
    }
    
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(msg);
        alert.showAndWait();
    }
    
    
}
