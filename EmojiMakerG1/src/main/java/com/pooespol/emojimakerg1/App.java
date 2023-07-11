package com.pooespol.emojimakerg1;

import Comparators.UserByNameComparator;
import Comparators.UserComparator;
import Controllers.AuthController;
import Controllers.MenuPrincipalController;
import Datos.Serializator;
import Modelos.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.TreeSet;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;

/**
 * JavaFX App
 */
public class App extends Application {
    private Scene authScene;
    private Scene menuPrincipalScene;
    private Scene createEmoticonScene;
    
    private Stage primaryStage;
    
    public static TreeSet<Usuario> usuarios;
    
    public static void main(String[] args) {
        usuarios = deserializeUsuarios();
        
        launch();
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        
        primaryStage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            Serializator.serialize(usuarios, "usuarios.se");
        });
        
        loadScenes();
        
        stage.setTitle("Inicia sesión");
        stage.setScene(authScene);
        stage.show();
    }
    
    public void switchToMenuPrincipal() {
        primaryStage.setScene(menuPrincipalScene);
        primaryStage.setTitle("Menu Principal");
    }
    
    public void createSession(Usuario usuario) {
        System.out.println("creando sesión");
    }

    public void openCreateEmoticonModal() {
        Stage stage = new Stage();
        stage.setScene(createEmoticonScene);
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage.getScene().getWindow());
        
        stage.setTitle("Create Emoticon");
        stage.show();
    }
    
    public void loadScenes() {
        try {
            FXMLLoader authLoader = new FXMLLoader(getClass().getClassLoader().getResource("views/auth.fxml"));
            FXMLLoader menuLoader = new FXMLLoader(getClass().getClassLoader().getResource("views/menuPrincipal.fxml"));
            FXMLLoader createEmoticonLoader = new FXMLLoader(getClass().getClassLoader().getResource("views/createEmoticon.fxml"));
            
            Parent auth = authLoader.load();
            Parent menu = menuLoader.load();
            Parent createEmoticon = createEmoticonLoader.load();
            
            AuthController authController = authLoader.getController();
            MenuPrincipalController menuPrincipalController = menuLoader.getController();
            
            authController.setApp(this);
            menuPrincipalController.setApp(this);
            
            authScene = new Scene(auth);
            menuPrincipalScene = new Scene(menu);
            createEmoticonScene = new Scene(createEmoticon);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static TreeSet<Usuario> deserializeUsuarios() {
        TreeSet<Usuario> usuariosDesearilizados = Serializator.deserialize("usuarios.se");
        
        if (usuariosDesearilizados == null) {
            usuariosDesearilizados = new TreeSet(new UserByNameComparator());
        }
        
        return usuariosDesearilizados;
    }
    
}