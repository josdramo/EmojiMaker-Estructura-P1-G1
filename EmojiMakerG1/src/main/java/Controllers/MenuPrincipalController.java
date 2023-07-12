/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import com.pooespol.emojimakerg1.App;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author infrative
 */
public class MenuPrincipalController {

    private App app;

    @FXML
    private VBox container;

    @FXML
    void onConsultarComponentes(ActionEvent event) {
        app.switchToModificacionComponente();
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
