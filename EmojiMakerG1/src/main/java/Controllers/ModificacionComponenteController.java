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
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

/**
 *
 * @author Dell
 */
public class ModificacionComponenteController {
    
    private App app;
    
    @FXML
    private Button btnAnadirBoca;

    @FXML
    private Button btnAnadirOjos;

    @FXML
    private Button btnAnadirRostro;

    @FXML
    private Button btnEliminarBoca;

    @FXML
    private Button btnEliminarOjos;

    @FXML
    private Button btnEliminarRostro;

    @FXML
    private Button btnMenuPrincipal;
    

    @FXML
    void anadirBoca(ActionEvent event) {
        String rutaBaseProyecto = System.getProperty("user.dir");
        String rutaCarpetaDestino = rutaBaseProyecto + "/src/main/resources/images";

        File carpetaDestino = new File(rutaCarpetaDestino);
        FileChooser archivoEscogido = new FileChooser();

        FileChooser.ExtensionFilter filtroPNG = new FileChooser.ExtensionFilter("Archivos PNG", "*.png");
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

    @FXML
    void anadirOjos(ActionEvent event) {

    }

    @FXML
    void anadirRostro(ActionEvent event) {

    }

    @FXML
    void eliminarBoca(ActionEvent event) {

    }

    @FXML
    void eliminarOjos(ActionEvent event) {

    }

    @FXML
    void eliminarRostro(ActionEvent event) {

    }

    @FXML
    void volverMenuPrincipal(ActionEvent event) {
        app.switchToMenuPrincipal();
    }
    
    public void setApp(App app) {
        this.app = app;
    }
}
