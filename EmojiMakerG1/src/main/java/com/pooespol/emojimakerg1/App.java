package com.pooespol.emojimakerg1;

import Comparators.ProfileByNameComparator;
import Controllers.AuthController;
import Controllers.MenuPrincipalController;
import Controllers.ConsultarEmojisController;
import Controllers.CreateEmoticonController;
import Controllers.ModificacionComponenteController;
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
    private Scene modificarComponenteScene;
    
    private ConsultarEmojisController consultarEmojisController;
    
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
        consultarEmojisController.build();
        primaryStage.setScene(consultarEmojiScene);
        primaryStage.setTitle("Consultar Emojis");
    }
    
    public void switchToModificacionComponente(){
        primaryStage.setScene(modificarComponenteScene);
        primaryStage.setTitle("Añadir / Eliminar componentes");
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
            FXMLLoader modificarComponenteLoader = new FXMLLoader(getClass().getClassLoader().getResource("views/modificacionComponente.fxml"));
            
            Parent auth = authLoader.load();
            Parent menu = menuLoader.load();
            Parent createEmoticon = createEmoticonLoader.load();
            Parent verEmojis = consultarEmojisLoader.load();
            Parent modificarComponente = modificarComponenteLoader.load();
            
            AuthController authController = authLoader.getController();
            MenuPrincipalController menuPrincipalController = menuLoader.getController();
            consultarEmojisController = consultarEmojisLoader.getController();
            CreateEmoticonController createEmoticonController = createEmoticonLoader.getController();
            ModificacionComponenteController  modificacionComponenteController = modificarComponenteLoader.getController();
            
            authController.setApp(this);
            menuPrincipalController.setApp(this);
            consultarEmojisController.setApp(this);
            createEmoticonController.setApp(this);
            modificacionComponenteController.setApp(this);
            
            authScene = new Scene(auth);
            menuPrincipalScene = new Scene(menu);
            createEmoticonScene = new Scene(createEmoticon);
            consultarEmojiScene = new Scene(verEmojis);
            modificarComponenteScene = new Scene(modificarComponente);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static TreeSet<Profile> deserializePerfiles() {
        TreeSet<Profile> perfilesDeserializados = Serializator.deserialize("perfiles.se");
        
        if (perfilesDeserializados == null) {
            perfilesDeserializados = new TreeSet(new ProfileByNameComparator());
        }
        
        return perfilesDeserializados;
    }

    public Profile getProfile() {
        return profile;
    }

    public ConsultarEmojisController getConsultarEmojisController() {
        return consultarEmojisController;
    }
    
    
    
}