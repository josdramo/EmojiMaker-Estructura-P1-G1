/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Enums.EmojiComponentType;
import Modelos.Emoticon;
import TDAS.CircularArray;
import TDAS.CircularList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

/**
 *
 * @author infrative
 */
public class CreateEmoticonController extends Controller {

    final private int CANTIDAD_COMPONENTES_MOSTRADOS = 3;
    final private int IMAGE_HEIGHT = 50;
    final private int IMAGE_WIDTH = 50;

    @FXML
    private VBox container;

    @FXML
    private HBox componentsHBox;

    @FXML
    private ImageView rostroImageView;

    @FXML
    private ImageView miradaImageView;

    @FXML
    private ImageView mouthImageView;

    private EmojiComponentType currentComponentType;
    private CircularList<String> componentes;
    private CircularArray<String> componentesMostrados;
    private Emoticon emoticon;
    private Integer indexEmoticonToEditInProfile = null;

    public void initialize() {
        emoticon = new Emoticon();
        String rutaBaseProyecto = System.getProperty("user.dir");
        Image img = new Image("file:" + rutaBaseProyecto + "/src/main/resources/views/fondo_ventanas.jpg");

        double width = 600;
        double height = 413;

        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        container.setBackground(background);
    }

    public void onDeshacer() {
        emoticon.restoreLastChange(this.getApp().getProfile().getComponentes());
        refreshEmoticonImageView();
    }

    public void onMostrarRostros() {
        currentComponentType = EmojiComponentType.FACE;

        componentes = this.getApp().getProfile().getComponentes().get(currentComponentType);

        cambiarComponentesMostrados();
        actualizarComponentsHBox();
    }

    public void onMostrarMiradas() {
        currentComponentType = EmojiComponentType.MIRADA;

        componentes = this.getApp().getProfile().getComponentes().get(currentComponentType);
        cambiarComponentesMostrados();
        actualizarComponentsHBox();
    }

    public void onMostrarMouths() {
        currentComponentType = EmojiComponentType.MOUTH;

        componentes = this.getApp().getProfile().getComponentes().get(currentComponentType);
        cambiarComponentesMostrados();
        actualizarComponentsHBox();
    }

    public void onMoverComponentesALaDerecha() {
        componentesMostrados.addLast(
                componentes.next(componentesMostrados.getLast())
        );

        actualizarComponentsHBox();
        updateEmoticon(1);
    }

    public void onMoverComponentesALaIzquierda() {
        componentesMostrados.addFirst(
                componentes.prev(componentesMostrados.getFirst())
        );

        actualizarComponentsHBox();
        updateEmoticon(1);
    }

    public void onGuardar() {
        Stage stage = (Stage) container.getScene().getWindow();

        if (indexEmoticonToEditInProfile != null && !emoticon.isEmpty()) {
            this.getApp().getProfile().getEmoticones()
                    .set(indexEmoticonToEditInProfile, emoticon);
        }

        if (indexEmoticonToEditInProfile == null && !emoticon.isEmpty()) {
            this.getApp().getProfile().getEmoticones().add(emoticon);
        }

        this.getApp().getConsultarEmojisController().build();

        stage.close();
        this.getApp().loadCreateEmoticonFxml();
    }

    public void onCancelar() {
        Stage stage = (Stage) container.getScene().getWindow();

        stage.close();
        this.getApp().loadCreateEmoticonFxml();
    }

    private void cambiarComponentesMostrados() {
        CircularArray<String> componentesParaMostrar = new CircularArray(CANTIDAD_COMPONENTES_MOSTRADOS);

        for (int i = 0; i < CANTIDAD_COMPONENTES_MOSTRADOS; i++) {
            componentesParaMostrar.addLast(componentes.get(i));
        }

        componentesMostrados = componentesParaMostrar;
    }

    private void actualizarComponentsHBox() {
        componentsHBox.getChildren().clear();

        for (int i = 0; i < CANTIDAD_COMPONENTES_MOSTRADOS; i++) {
            ImageView imageView = new ImageView(new Image(componentesMostrados.get(i)));

            imageView.setFitWidth(IMAGE_WIDTH);
            imageView.setFitHeight(IMAGE_HEIGHT);
            imageView.setPickOnBounds(true);

            final int indiceComponenteSeleccionado = i;
            imageView.setOnMouseClicked((e) -> {
                this.updateEmoticon(indiceComponenteSeleccionado);
            });

            componentsHBox.getChildren().add(imageView);
        }
    }

    private void updateEmoticon(int indiceComponente) {
        emoticon.updateComponent(currentComponentType, componentesMostrados.get(indiceComponente));

        refreshEmoticonImageView();
    }

    private void refreshEmoticonImageView() {
        String miradaUrl = emoticon.getComponent(EmojiComponentType.MIRADA);
        String rostroUrl = emoticon.getComponent(EmojiComponentType.FACE);
        String mouthUrl = emoticon.getComponent(EmojiComponentType.MOUTH);

        if (miradaUrl != null) {
            miradaImageView.setImage(new Image(miradaUrl));
        }

        if (rostroUrl != null) {
            rostroImageView.setImage(new Image(rostroUrl));
        }

        if (mouthUrl != null) {
            mouthImageView.setImage(new Image(mouthUrl));
        }
    }

    public void setIndexEmoticonToEditInProfile(int indexEmoticonToEditInProfile) {
        this.indexEmoticonToEditInProfile = indexEmoticonToEditInProfile;

        this.emoticon = this.getApp().getProfile().getEmoticones().get(indexEmoticonToEditInProfile);
        refreshEmoticonImageView();
    }
}
