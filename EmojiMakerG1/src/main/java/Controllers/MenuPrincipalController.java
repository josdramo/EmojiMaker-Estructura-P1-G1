/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import com.pooespol.emojimakerg1.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author infrative
 */
public class MenuPrincipalController {
    private App app;
    
    @FXML
    private Button crearButton;
    
    @FXML
    public void abrirVentanaEmoji() {
        //System.out.println("dddd");  
        try {
            FXMLLoader createEmoticonLoader = new FXMLLoader(getClass().getClassLoader().getResource("views/createEmoticon.fxml"));
            Parent auth = createEmoticonLoader.load();
            Scene createEmoticonScene = new Scene(auth);

            Stage stage = new Stage();
            stage.setScene(createEmoticonScene);
            
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(crearButton.getScene().getWindow());
            
            stage.setTitle("Create Emoticon");
            stage.show();
        } catch (IOException e) {
            
        }

    }

    public void setApp(App app) {
        this.app = app;
    }
    
    
}
