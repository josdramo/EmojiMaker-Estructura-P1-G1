/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import static Datos.LeerArchivos.listaR;
import TDAS.CircularList;
import TDAS.ListaCircularDoble;
import com.pooespol.emojimakerg1.App;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class ModificacionComponenteController {

    Stage stage = new Stage();
    private App app;
    private String directorioEspecifico;

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
        directorioEspecifico = "mouth";
        copiarArchivoEnCarpetaDeImagenes(directorioEspecifico);
    }

    @FXML
    void anadirOjos(ActionEvent event) {
        directorioEspecifico = "eyes";
        copiarArchivoEnCarpetaDeImagenes(directorioEspecifico);
    }

    @FXML
    void anadirRostro(ActionEvent event) {
        directorioEspecifico = "faces";
        copiarArchivoEnCarpetaDeImagenes(directorioEspecifico);
    }

    @FXML
    void eliminarBoca(ActionEvent event) {

    }

    @FXML
    void eliminarOjos(ActionEvent event) {

    }

    @FXML
    void eliminarRostro(ActionEvent event) {
        CircularList<String> listaRostros = listaR();

// Crear un GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label label = new Label("Selecciona el emoji para borrar un componente de rostros");
           gridPane.add(label, 0, 0, 6, 1);
// Variables para controlar las posiciones en el GridPane
        int column = 0;
        int row = 0;

// Recorrer la lista de rutas de imágenes utilizando un bucle for tradicional
        for (int i = 0; i < listaRostros.size(); i++) {
            String rutaImagen = listaRostros.get(i);

            // Crear un ImageView para cada imagen
            ImageView imageView = new ImageView(new Image("file:" + rutaImagen));
            imageView.setFitWidth(100); // Ancho deseado del ImageView
            imageView.setPreserveRatio(true); // Mantener la relación de aspecto

            // Agregar el ImageView al GridPane en la posición actual
            gridPane.add(imageView, column, row);

            // Actualizar las posiciones en el GridPane
            column++;
            if (column == 6) {
                column = 0;
                row++;
            }
            int index = i; // Guardar el índice actual en una variable final para utilizar en el evento
        imageView.setOnMouseClicked(e -> {
            // Eliminar el emoji de la lista
            System.out.println(listaRostros);
            listaRostros.removeByIndex(index);
            
            // Mostrar un aviso de que el emoji fue eliminado
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("El emoji seleccionado fue eliminado");
            alert.showAndWait();
            
            // Actualizar el GridPane con los emojis restantes
            eliminarRostro(event); // Llamar al método nuevamente para generar la nueva vista
        });
    }
        // Crear la escena y mostrarla en el escenario
        Scene scene = new Scene(gridPane, 700, 700);
        stage.setTitle("Eliminar rostros");
        stage.setScene(scene);
        stage.show();
        }
        



    @FXML
    void volverMenuPrincipal(ActionEvent event) {
        app.switchToMenuPrincipal();
    }

    public void copiarArchivoEnCarpetaDeImagenes(String directorioEspecifico) {
        String rutaBaseProyecto = System.getProperty("user.dir");
        String rutaCarpetaDestino = rutaBaseProyecto + "/src/main/resources/images/" + directorioEspecifico;

        File carpetaDestino = new File(rutaCarpetaDestino);
        FileChooser archivoEscogido = new FileChooser();

        FileChooser.ExtensionFilter filtroPNG = new FileChooser.ExtensionFilter("Archivos PNG", "*.png");
        archivoEscogido.getExtensionFilters().add(filtroPNG);

        File archivoImagen = archivoEscogido.showOpenDialog(null);
        if (archivoImagen != null) {
            try {
                Path rutaDestino = carpetaDestino.toPath().resolve(archivoImagen.getName());

                Files.copy(archivoImagen.toPath(), rutaDestino, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setApp(App app) {
        this.app = app;
    }
}
