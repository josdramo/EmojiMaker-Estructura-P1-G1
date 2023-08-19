/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import static Datos.LeerArchivos.listaR;
import Enums.EmojiComponentType;
import TDAS.CircularList;
import TDAS.ListaCircularDoble;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class ModificacionComponenteController extends Controller {

    @FXML
    private VBox container;

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
        this.getApp().getProfile().getComponentes().get(EmojiComponentType.MOUTH).add(copiarArchivoEnCarpetaDeImagenes(directorioEspecifico));
    }

    @FXML
    void anadirOjos(ActionEvent event) {
        directorioEspecifico = "eyes";
        this.getApp().getProfile().getComponentes().get(EmojiComponentType.MIRADA).add(copiarArchivoEnCarpetaDeImagenes(directorioEspecifico));
    }

    @FXML
    void anadirRostro(ActionEvent event) {
        directorioEspecifico = "faces";
        this.getApp().getProfile().getComponentes().get(EmojiComponentType.FACE).add(copiarArchivoEnCarpetaDeImagenes(directorioEspecifico));
    }

    @FXML
    void eliminarBoca(ActionEvent event) {
        Stage stageBoca = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label label = new Label("Selecciona el emoji para borrar un componente de boca");
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 25;");
        label.setTextFill(Color.WHITE);
        gridPane.add(label, 0, 0, 6, 1);
        int column = 0;
        int row = 2;

        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setValignment(label, VPos.CENTER);

        for (int i = 0; i < this.getApp().getProfile().getComponentes().get(EmojiComponentType.MOUTH).size(); i++) {
            String rutaImagen = this.getApp().getProfile().getComponentes().get(EmojiComponentType.MOUTH).get(i);

            ImageView imageView = new ImageView(new Image(rutaImagen));
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);

            gridPane.add(imageView, column, row);

            column++;
            if (column == 7) {
                column = 0;
                row++;
            }
            int index = i;
            imageView.setOnMouseClicked(e -> {
                this.getApp().getProfile().getComponentes().get(EmojiComponentType.MOUTH).removeByIndex(index);

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Aviso");
                alert.setHeaderText(null);
                alert.setContentText("El emoji seleccionado fue eliminado");
                alert.showAndWait();

                Stage stageActual = (Stage) imageView.getScene().getWindow();
                stageActual.close();
                
                eliminarBoca(event);
            });
        }
        Scene scene = new Scene(gridPane, 800, 700);
        String rutaBaseProyecto = System.getProperty("user.dir");
        Image img = new Image("file:" + rutaBaseProyecto + "/src/main/resources/views/fondo_ventanas.jpg");

        double width = 800;
        double height = 700;

        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        gridPane.setBackground(background);
        stageBoca.setTitle("Eliminar boca");
        stageBoca.setScene(scene);
        stageBoca.show();
    }

    @FXML
    void eliminarOjos(ActionEvent event) {
        Stage stageOjos = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label label = new Label("Selecciona el emoji para borrar un componente de ojos");
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 25;");
        label.setTextFill(Color.WHITE);
        gridPane.add(label, 0, 0, 6, 1);
        int column = 0;
        int row = 2;

        for (int i = 0; i < this.getApp().getProfile().getComponentes().get(EmojiComponentType.MIRADA).size(); i++) {
            String rutaImagen = this.getApp().getProfile().getComponentes().get(EmojiComponentType.MIRADA).get(i);

            ImageView imageView = new ImageView(new Image(rutaImagen));
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);

            gridPane.add(imageView, column, row);

            column++;
            if (column == 7) {
                column = 0;
                row++;
            }
            int index = i;
            imageView.setOnMouseClicked(e -> {
                this.getApp().getProfile().getComponentes().get(EmojiComponentType.MIRADA).removeByIndex(index);

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Aviso");
                alert.setHeaderText(null);
                alert.setContentText("El emoji seleccionado fue eliminado");
                alert.showAndWait();
                
                Stage stageActual = (Stage) imageView.getScene().getWindow();
                stageActual.close();
    
                eliminarOjos(event);
            });
        }
        Scene scene = new Scene(gridPane, 800, 700);
        String rutaBaseProyecto = System.getProperty("user.dir");
        Image img = new Image("file:" + rutaBaseProyecto + "/src/main/resources/views/fondo_ventanas.jpg");

        double width = 800;
        double height = 700;

        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        gridPane.setBackground(background);
        stageOjos.setTitle("Eliminar ojos");
        stageOjos.setScene(scene);
        stageOjos.show();
    }

    @FXML
    void eliminarRostro(ActionEvent event) {
        Stage stageRostro = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label label = new Label("Selecciona el emoji para borrar un componente de rostros");
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 25;");
        label.setTextFill(Color.WHITE);
        gridPane.add(label, 0, 0, 6, 1);
        int column = 0;
        int row = 2;

        for (int i = 0; i < this.getApp().getProfile().getComponentes().get(EmojiComponentType.FACE).size(); i++) {
            String rutaImagen = this.getApp().getProfile().getComponentes().get(EmojiComponentType.FACE).get(i);

            ImageView imageView = new ImageView(new Image(rutaImagen));
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);

            gridPane.add(imageView, column, row);

            column++;
            if (column == 7) {
                column = 0;
                row++;
            }
            int index = i;
            imageView.setOnMouseClicked(e -> {
                this.getApp().getProfile().getComponentes().get(EmojiComponentType.FACE).removeByIndex(index);

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Aviso");
                alert.setHeaderText(null);
                alert.setContentText("El emoji seleccionado fue eliminado");
                alert.showAndWait();

                Stage stageActual = (Stage) imageView.getScene().getWindow();
                stageActual.close();
    
                eliminarRostro(event);
            });
        }
        Scene scene = new Scene(gridPane, 800, 700);
        String rutaBaseProyecto = System.getProperty("user.dir");
        Image img = new Image("file:" + rutaBaseProyecto + "/src/main/resources/views/fondo_ventanas.jpg");

        double width = 800;
        double height = 700;

        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        gridPane.setBackground(background);
        stageRostro.setTitle("Eliminar rostros");
        stageRostro.setScene(scene);
        stageRostro.show();
    }

    @FXML
    void volverMenuPrincipal(ActionEvent event) {
        this.getApp().switchToMenuPrincipal();
    }

    public String copiarArchivoEnCarpetaDeImagenes(String directorioEspecifico) {
        String rutaBaseProyecto = System.getProperty("user.dir");
        String rutaCarpetaDestino = rutaBaseProyecto + "/src/main/resources/images/" + directorioEspecifico;

        FileChooser archivoEscogido = new FileChooser();

        FileChooser.ExtensionFilter filtroPNG = new FileChooser.ExtensionFilter("Archivos PNG", "*.png");
        archivoEscogido.getExtensionFilters().add(filtroPNG);

        File archivoSeleccionado = archivoEscogido.showOpenDialog(null);
        if (archivoSeleccionado != null) {
            String rutaArchivoSeleccionado = archivoSeleccionado.getAbsolutePath();
            return "file:" + rutaArchivoSeleccionado;
        }
        return null;
    }
    
    public void initialize(){
        String rutaBaseProyecto = System.getProperty("user.dir");
        Image img = new Image("file:" + rutaBaseProyecto + "/src/main/resources/views/fondo_ventanas.jpg");

        double width = 600;
        double height = 400;

        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        container.setBackground(background);
    }
}
