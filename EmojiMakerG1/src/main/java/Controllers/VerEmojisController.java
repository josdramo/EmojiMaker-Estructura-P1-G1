/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import com.pooespol.emojimakerg1.App;

/**
 *
 * @author infrative
 */
public class VerEmojisController {
    private App app;
    
    public void onVolverAlMenu() {
        app.switchToMenuPrincipal();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
