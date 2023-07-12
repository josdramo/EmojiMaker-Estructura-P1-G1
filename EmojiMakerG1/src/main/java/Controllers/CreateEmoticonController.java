/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Datos.LeerArchivos;
import TDAS.ListaCircularDoble;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author infrative
 */
public class CreateEmoticonController implements Initializable{

    ListaCircularDoble<String> rostros = LeerArchivos.listaR();
    ListaCircularDoble<String> ojos = LeerArchivos.listaO();
    ListaCircularDoble<String> bocas = LeerArchivos.listaB();

    int indiceRostros = 0;
    int indiceOjos = 0;
    int indiceBocas = 0;

    private String componente;

    @FXML
    private ImageView imageViewBoca;

    @FXML
    private ImageView imageViewOjos;

    @FXML
    private ImageView imageViewRostro;

    @FXML
    public ImageView imgC1;

    @FXML
    public ImageView imgC2;

    @FXML
    public ImageView imgC3;
    
    @FXML
    public Label title;

    @FXML
    public void cargarR() {
        componente = "rostro";
        title.setText("Seleccionando rostro: ");
        try ( FileInputStream input = new FileInputStream(rostros.get(indiceRostros))) {
            Image img1 = new Image(input);
            imgC1.setImage(img1);
        } catch (IOException e) {

        }
        try ( FileInputStream input = new FileInputStream(rostros.get(indiceRostros + 1))) {
            Image img = new Image(input);
            imgC2.setImage(img);
        } catch (IOException e) {

        }
        try ( FileInputStream input = new FileInputStream(rostros.get(indiceRostros + 2))) {
            Image img = new Image(input);
            imgC3.setImage(img);
        } catch (IOException e) {

        }

    }

    @FXML
    public void cargarO() {
        componente = "ojos";
        title.setText("Seleccionando ojos: ");
        try ( FileInputStream input = new FileInputStream(ojos.get(indiceOjos))) {
            Image img1 = new Image(input);
            imgC1.setImage(img1);
        } catch (IOException e) {

        }
        try ( FileInputStream input = new FileInputStream(ojos.get(indiceOjos + 1))) {
            Image img = new Image(input);
            imgC2.setImage(img);
        } catch (IOException e) {

        }
        try ( FileInputStream input = new FileInputStream(ojos.get(indiceOjos + 2))) {
            Image img = new Image(input);
            imgC3.setImage(img);
        } catch (IOException e) {

        }

    }

    @FXML
    public void cargarB() {
        componente = "boca";
        title.setText("Seleccionando boca: ");
        try ( FileInputStream input = new FileInputStream(bocas.get(indiceBocas))) {
            Image img1 = new Image(input);
            imgC1.setImage(img1);
        } catch (IOException e) {

        }
        try ( FileInputStream input = new FileInputStream(bocas.get(indiceBocas + 1))) {
            Image img = new Image(input);
            imgC2.setImage(img);
        } catch (IOException e) {

        }
        try ( FileInputStream input = new FileInputStream(bocas.get(indiceBocas + 2))) {
            Image img = new Image(input);
            imgC3.setImage(img);
        } catch (IOException e) {

        }
    }

    @FXML
    public void elementoNext() {
        if (componente == null) {
            String mensaje = "Este es un mensaje de aviso.";

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }
        if (componente == "rostro") {
            indiceRostros++;
        } else if (componente == "ojos") {
            indiceOjos++;
        } else {
            indiceBocas++;
        }
    }

    @FXML
    public void elementoPrev() {
        if (componente == null) {
            String mensaje = "Este es un mensaje de aviso.";

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }
        if (componente == "rostro") {
            int a = indiceRostros - 1;
            if (a < 0) {
                indiceRostros = rostros.size() + a;
            } else {
                indiceRostros--;
            }
        } else if (componente == "ojos") {
            int a = indiceOjos - 1;
            if (a < 0) {
                indiceOjos = ojos.size() + a;
            } else {
                indiceOjos--;
            }
        } else {
            int a = indiceBocas - 1;
            if (a < 0) {
                indiceBocas = bocas.size() + a;
            } else {
                indiceBocas--;
            }
        }
    }

    @FXML
    void agregarPrevisualizacionIV1(MouseEvent event) {
        if (componente == null) {
            String mensaje = "Selecciona un componente...";

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }
        if (componente == "rostro") {
            Image imgPrevisualizacion1 = imgC1.getImage();
            imageViewRostro.setImage(imgPrevisualizacion1);
        } else if (componente == "ojos") {
            Image imgPrevisualizacion1 = imgC1.getImage();
            imageViewOjos.setImage(imgPrevisualizacion1);
        } else {
            Image imgPrevisualizacion1 = imgC1.getImage();
            imageViewBoca.setImage(imgPrevisualizacion1);
        }
    }

    @FXML
    void agregarPrevisualizacionIV2(MouseEvent event) {
        if (componente == null) {
            String mensaje = "Este es un mensaje de aviso.";

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }
        if (componente == "rostro") {
            Image imgPrevisualizacion1 = imgC2.getImage();
            imageViewRostro.setImage(imgPrevisualizacion1);
        } else if (componente == "ojos") {
            Image imgPrevisualizacion1 = imgC2.getImage();
            imageViewOjos.setImage(imgPrevisualizacion1);
        } else {
            Image imgPrevisualizacion1 = imgC2.getImage();
            imageViewBoca.setImage(imgPrevisualizacion1);
        }
    }

    @FXML
    void agregarPrevisualizacionIV3(MouseEvent event) {
        if (componente == null) {
            String mensaje = "Este es un mensaje de aviso.";

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        } else if (componente == "rostro") {
            Image imgPrevisualizacion1 = imgC3.getImage();
            imageViewRostro.setImage(imgPrevisualizacion1);
        } else if (componente == "ojos") {
            Image imgPrevisualizacion1 = imgC3.getImage();
            imageViewOjos.setImage(imgPrevisualizacion1);
        } else {
            Image imgPrevisualizacion1 = imgC3.getImage();
            imageViewBoca.setImage(imgPrevisualizacion1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
