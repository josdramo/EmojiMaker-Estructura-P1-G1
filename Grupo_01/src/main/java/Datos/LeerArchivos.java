/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import TDAS.ListaCircularDoble;
import java.io.File;

/**
 *
 * @author Dell
 */
public class LeerArchivos {
    public static ListaCircularDoble<String> listaR(){
        ListaCircularDoble<String> listaRostros = new ListaCircularDoble<>();
        String carpeta = "src/main/resources/images/faces/"; // Ruta de la carpeta que contiene las imágenes
        String extension = ".png"; // Extensión de los archivos de imagen

        File folder = new File(carpeta);
        File[] archivos = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(extension));
        
        for(File i:archivos){
            listaRostros.add("file:" + i.getAbsolutePath());
        }
        return listaRostros;
    }
    
    public static ListaCircularDoble<String> listaO(){
        ListaCircularDoble<String> listaOjos = new ListaCircularDoble<>();
        String carpeta = "src/main/resources/images/eyes/"; // Ruta de la carpeta que contiene las imágenes
        String extension = ".png"; // Extensión de los archivos de imagen

        File folder = new File(carpeta);
        File[] archivos = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(extension));
        
        for(File i:archivos){
            listaOjos.add("file:" + i.getAbsolutePath());
        }
        
        return listaOjos;
    }
    
    public static ListaCircularDoble<String> listaB(){
        ListaCircularDoble<String> listaBocas = new ListaCircularDoble<>();
        String carpeta = "src/main/resources/images/mouth/"; // Ruta de la carpeta que contiene las imágenes
        String extension = ".png"; // Extensión de los archivos de imagen

        File folder = new File(carpeta);
        File[] archivos = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(extension));
        
        for(File i:archivos){
            listaBocas.add("file:" + i.getAbsolutePath());
        }
        
        return listaBocas;
    }
}
