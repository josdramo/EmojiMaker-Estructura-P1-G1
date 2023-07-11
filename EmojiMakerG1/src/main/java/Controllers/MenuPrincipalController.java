/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import com.pooespol.emojimakerg1.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author infrative
 */
public class MenuPrincipalController {
    private App app;
    
    @FXML
    private Button crearButton;
    
    @FXML
    public void abrirVentanaEmoji() {
        app.openCreateEmoticonModal();

    }

    public void setApp(App app) {
        this.app = app;
    }
    
}
