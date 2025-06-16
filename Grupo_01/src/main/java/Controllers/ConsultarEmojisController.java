/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Components.EmoticonItem;
import Modelos.Emoji;
import Modelos.Emoticon;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;

/**
 *
 * @author infrative
 */
public class ConsultarEmojisController extends Controller {

    @FXML
    private VBox container;

    @FXML
    private ListView<Emoticon> emojisListView;

    public void initialize() {
        String rutaBaseProyecto = System.getProperty("user.dir");
        Image img = new Image("file:" + rutaBaseProyecto + "/src/main/resources/views/fondo_ventanas.jpg");

        double width = 500;
        double height = 438;

        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        container.setBackground(background);

        emojisListView.setCellFactory(param -> new ListCell<Emoticon>() {
            private final EmoticonItem emoticonItem = new EmoticonItem();

            @Override
            protected void updateItem(Emoticon emoticon, boolean empty) {
                super.updateItem(emoticon, empty);

                if (empty) {
                    setGraphic(null);
                }

                if (!empty) {

                    emoticonItem.setEmoticon(emoticon);
                    setGraphic(emoticonItem);
                }
            }
        });
    }

    public void build() {
        buildEmojisListView();
    }

    public void onVolverAlMenu() {
        this.getApp().switchToMenuPrincipal();
    }

    public void onAgregar() {
        this.getApp().openCreateEmoticonModal();
    }

    public void onEditar() {
        Integer emojiSelectedIndex = emojisListView.getSelectionModel().getSelectedIndex();
        if (emojiSelectedIndex != -1) {
            this.getApp().openCreateEmoticonModal(emojiSelectedIndex);
        }
    }

    public void onEliminar() {
        int idx = emojisListView.getSelectionModel().getSelectedIndex();
        if (idx != -1) {
            this.getApp().getProfile().getEmoticones().remove(idx);
            buildEmojisListView();
        };
    }

    private void buildEmojisListView() {
        emojisListView.getItems().clear();

        for (Emoticon emoticon : this.getApp().getProfile().getEmoticones()) {

            emojisListView.getItems().add(emoticon);
        }
    }
}
