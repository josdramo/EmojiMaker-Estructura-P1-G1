/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Components.EmoticonItem;
import Modelos.Emoji;
import Modelos.Emoticon;
import com.pooespol.emojimakerg1.App;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 *
 * @author infrative
 */
public class ConsultarEmojisController {
    private App app;
    
    @FXML
    private VBox container;
    
    @FXML
    private ListView<Emoticon> emojisListView;
    
    public void initialize() {
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
        app.switchToMenuPrincipal();
    }
    
    public void onAgregar() {
        app.openCreateEmoticonModal();
    }
    
    public void onEditar() {
        // TODO
    }
    
    public void onEliminar() {
        // TODO
    }

    public void setApp(App app) {
        this.app = app;
    }
    
    private void buildEmojisListView() {
        emojisListView.getItems().clear();
        
        for (Emoticon emoticon : app.getProfile().getEmoticones()) {
            
            emojisListView.getItems().add(emoticon);
        }
    }
}
