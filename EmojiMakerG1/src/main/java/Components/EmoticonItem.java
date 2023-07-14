/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Enums.EmojiComponentType;
import Modelos.Emoticon;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author infrative
 */
public class EmoticonItem extends StackPane {
    private Emoticon emoticon;
    
    @FXML
    private ImageView rostroImageView;
    
    @FXML
    private ImageView miradaImageView;
    
    @FXML
    private ImageView mouthImageView;
    
    public EmoticonItem() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("views/emoticon.fxml"));
        
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void build() {
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

    public void setEmoticon(Emoticon emoticon) {
        this.emoticon = emoticon;
        this.build();
    }
}
