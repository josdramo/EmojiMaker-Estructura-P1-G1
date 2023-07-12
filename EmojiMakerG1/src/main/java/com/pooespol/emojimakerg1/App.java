package com.pooespol.emojimakerg1;

import Comparators.ProfileByNameComparator;
import Controllers.AuthController;
import Controllers.MenuPrincipalController;
import Controllers.ConsultarEmojisController;
import Controllers.CreateEmoticonController;
import Datos.Serializator;
import Modelos.Profile;
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
    private Scene consultarEmojiScene;
    
    private Stage primaryStage;
    
    private Profile profile;
    
    public static TreeSet<Profile> perfiles;
    
    public static void main(String[] args) {
        perfiles = deserializePerfiles();
        
        launch();
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        
        primaryStage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            Serializator.serialize(perfiles, "perfiles.se");
        });
        
        loadScenes();
        
        switchToAuth();
        
        stage.show();
    }
    
    public void switchToAuth() {
        primaryStage.setTitle("Inicia sesión");
        primaryStage.setScene(authScene);
    }
    
    public void switchToMenuPrincipal() {
        primaryStage.setScene(menuPrincipalScene);
        primaryStage.setTitle("Menu Principal");
    }
    
    public void switchToConsultarEmojis() {
        primaryStage.setScene(consultarEmojiScene);
        primaryStage.setTitle("Consultar Emojis");
    }
    
    public void createSession(Profile profile) {
        System.out.println("creando sesión");
        this.profile = profile;
        
        
        switchToMenuPrincipal();
        
         // TODO: Crear perfil
    }
    
    public void destroySession() {
        System.out.println("cerrar sesión");
        
        loadScenes();
        
        this.profile = null;
        
        switchToAuth();
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
            FXMLLoader consultarEmojisLoader = new FXMLLoader(getClass().getClassLoader().getResource("views/consultarEmojis.fxml"));
            
            Parent auth = authLoader.load();
            Parent menu = menuLoader.load();
            Parent createEmoticon = createEmoticonLoader.load();
            Parent verEmojis = consultarEmojisLoader.load();
            
            AuthController authController = authLoader.getController();
            MenuPrincipalController menuPrincipalController = menuLoader.getController();
            ConsultarEmojisController verEmojisController = consultarEmojisLoader.getController();
            CreateEmoticonController createEmoticonController = createEmoticonLoader.getController();
            
            authController.setApp(this);
            menuPrincipalController.setApp(this);
            verEmojisController.setApp(this);
            createEmoticonController.setApp(this);
            
            authScene = new Scene(auth);
            menuPrincipalScene = new Scene(menu);
            createEmoticonScene = new Scene(createEmoticon);
            consultarEmojiScene = new Scene(verEmojis);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static TreeSet<Profile> deserializePerfiles() {
        TreeSet<Profile> perfilesDeserializados = Serializator.deserialize("perfiles.se");
        
        if (perfilesDeserializados == null) {
            perfilesDeserializados = new TreeSet(new ProfileByNameComparator());
        }
        
        return new TreeSet(new ProfileByNameComparator());
    }

    public Profile getProfile() {
        return profile;
    }
    
}