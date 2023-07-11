/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Datos.LeerArchivos;
import TDAS.ListaCircularDoble;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author infrative
 */
public class CreateEmoticonController {
    ListaCircularDoble<String> rostros= LeerArchivos.listaR();
    Stack<String> pilaR= new Stack<>();
    @FXML
    public ImageView imgC1;
    
    @FXML
    public ImageView imgC2;
    
    @FXML
    public ImageView imgC3;
    
    @FXML
    public void cargarR(){
        try(FileInputStream input= new FileInputStream(rostros.get(0))){
            Image img1= new Image(input);
            imgC1.setImage(img1);
        }catch(IOException e){
            
        }
        try(FileInputStream input= new FileInputStream(rostros.get(0))){
            Image img= new Image(input);
            imgC2.setImage(img);
        }catch(IOException e){
            
        }
        try(FileInputStream input= new FileInputStream(rostros.get(0))){
            Image img= new Image(input);
            imgC3.setImage(img);
        }catch(IOException e){
            
        }
        
    }
}
