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
        String rutaBaseProyecto = System.getProperty("user.dir");
        String rutaCarpetaDestino = rutaBaseProyecto + "/src/main/resources/images";

        File carpetaDestino = new File(rutaCarpetaDestino);
        FileChooser archivoEscogido = new FileChooser();

        ExtensionFilter filtroPNG = new ExtensionFilter("Archivos PNG", "*.png");
        archivoEscogido.getExtensionFilters().add(filtroPNG);

        File archivoImagen = archivoEscogido.showOpenDialog(null);
        if (archivoImagen != null) {
            try{
             Path rutaDestino = carpetaDestino.toPath().resolve(archivoImagen.getName());

 
            Files.copy(archivoImagen.toPath(), rutaDestino, StandardCopyOption.REPLACE_EXISTING);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
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
