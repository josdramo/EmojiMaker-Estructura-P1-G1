/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import javafx.scene.image.Image;

/**
 *
 * @author infrative
 */
public class EmojiComponent extends Model {
    private Image image;

    public EmojiComponent(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
}
