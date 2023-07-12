/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import com.pooespol.emojimakerg1.App;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

/**
 *
 * @author infrative
 */
public class MenuPrincipalController {
    private App app;
    
    @FXML
    private VBox container;
    
    public void onConsultarComponentes() {
        // TODO
    }
    
    public void onConsultarEmojis() {
        app.switchToConsultarEmojis();
    }
    
    public void onSalir() {
        app.destroySession();
    }

    public void setApp(App app) {
        this.app = app;
    }
    
}
