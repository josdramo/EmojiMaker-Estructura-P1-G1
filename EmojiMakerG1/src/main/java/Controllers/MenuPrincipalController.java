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
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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
    
    public void initialize(){
        String rutaBaseProyecto = System.getProperty("user.dir");
        Image img = new Image(rutaBaseProyecto + "/src/main/resources/views/fondo_ventanas.jpg");

        double width = 300;
        double height = 290;

        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        container.setBackground(background);
    }
}
