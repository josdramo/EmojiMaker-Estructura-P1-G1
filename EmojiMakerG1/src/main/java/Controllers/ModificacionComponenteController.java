/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import static Datos.LeerArchivos.listaR;
import Enums.EmojiComponentType;
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
    App app;
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
        app.getProfile().getComponentes().get(EmojiComponentType.MOUTH).add(copiarArchivoEnCarpetaDeImagenes(directorioEspecifico));
    }

    @FXML
    void anadirOjos(ActionEvent event) {
        directorioEspecifico = "eyes";
        app.getProfile().getComponentes().get(EmojiComponentType.MIRADA).add(copiarArchivoEnCarpetaDeImagenes(directorioEspecifico));
    }

    @FXML
    void anadirRostro(ActionEvent event) {
        directorioEspecifico = "faces";
        app.getProfile().getComponentes().get(EmojiComponentType.FACE).add(copiarArchivoEnCarpetaDeImagenes(directorioEspecifico));
    }

    @FXML
    void eliminarBoca(ActionEvent event) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label label = new Label("Selecciona el emoji para borrar un componente de boca");
        gridPane.add(label, 0, 0, 6, 1);
        int column = 0;
        int row = 0;

        for (int i = 0; i < app.getProfile().getComponentes().get(EmojiComponentType.MOUTH).size(); i++) {
            String rutaImagen = app.getProfile().getComponentes().get(EmojiComponentType.MOUTH).get(i);

            ImageView imageView = new ImageView(new Image("file:" + rutaImagen));
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);

            gridPane.add(imageView, column, row);

            column++;
            if (column == 6) {
                column = 0;
                row++;
            }
            int index = i;
            imageView.setOnMouseClicked(e -> {
            app.getProfile().getComponentes().get(EmojiComponentType.MOUTH).removeByIndex(index);
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("El emoji seleccionado fue eliminado");
            alert.showAndWait();
            
            eliminarRostro(event);
            });
        }
        Scene scene = new Scene(gridPane, 700, 700);
        stage.setTitle("Eliminar rostros");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void eliminarOjos(ActionEvent event) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label label = new Label("Selecciona el emoji para borrar un componente de ojos");
        gridPane.add(label, 0, 0, 6, 1);
        int column = 0;
        int row = 0;

        for (int i = 0; i < app.getProfile().getComponentes().get(EmojiComponentType.MIRADA).size(); i++) {
            String rutaImagen = app.getProfile().getComponentes().get(EmojiComponentType.MIRADA).get(i);

            ImageView imageView = new ImageView(new Image("file:" + rutaImagen));
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);

            gridPane.add(imageView, column, row);

            column++;
            if (column == 6) {
                column = 0;
                row++;
            }
            int index = i;
            imageView.setOnMouseClicked(e -> {
            app.getProfile().getComponentes().get(EmojiComponentType.MIRADA).removeByIndex(index);
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("El emoji seleccionado fue eliminado");
            alert.showAndWait();
            
            eliminarRostro(event);
            });
        }
        Scene scene = new Scene(gridPane, 700, 700);
        stage.setTitle("Eliminar rostros");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void eliminarRostro(ActionEvent event) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label label = new Label("Selecciona el emoji para borrar un componente de rostros");
        gridPane.add(label, 0, 0, 6, 1);
        int column = 0;
        int row = 0;

        for (int i = 0; i < app.getProfile().getComponentes().get(EmojiComponentType.FACE).size(); i++) {
            String rutaImagen = app.getProfile().getComponentes().get(EmojiComponentType.FACE).get(i);

            ImageView imageView = new ImageView(new Image("file:" + rutaImagen));
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);

            gridPane.add(imageView, column, row);

            column++;
            if (column == 6) {
                column = 0;
                row++;
            }
            int index = i;
            imageView.setOnMouseClicked(e -> {
            app.getProfile().getComponentes().get(EmojiComponentType.FACE).removeByIndex(index);
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("El emoji seleccionado fue eliminado");
            alert.showAndWait();
            
            eliminarRostro(event);
            });
        }
        Scene scene = new Scene(gridPane, 700, 700);
        stage.setTitle("Eliminar rostros");
        stage.setScene(scene);
        stage.show();
        }
        



    @FXML
    void volverMenuPrincipal(ActionEvent event) {
        app.switchToMenuPrincipal();
    }

    public String copiarArchivoEnCarpetaDeImagenes(String directorioEspecifico) {
        String rutaBaseProyecto = System.getProperty("user.dir");
        String rutaCarpetaDestino = rutaBaseProyecto + "/src/main/resources/images/" + directorioEspecifico;

        FileChooser archivoEscogido = new FileChooser();

        FileChooser.ExtensionFilter filtroPNG = new FileChooser.ExtensionFilter("Archivos PNG", "*.png");
        archivoEscogido.getExtensionFilters().add(filtroPNG);

        archivoEscogido.showOpenDialog(null);
       
        return archivoEscogido.toString();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
