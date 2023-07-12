/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Modelos.Emoji;
import com.pooespol.emojimakerg1.App;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 *
 * @author infrative
 */
public class ConsultarEmojisController {
    private App app;
    
    @FXML
    private VBox container;
    
    @FXML
    private ListView<Emoji> emojisListView;
    
    public void onVolverAlMenu() {
        app.switchToMenuPrincipal();
    }
    
    public void onAgregar() {
        app.openCreateEmoticonModal();
    }
    
    public void onEditar() {
        // TODO
    }
    
    public void onEliminar() {
        // TODO
    }

    public void setApp(App app) {
        this.app = app;
    }
}
