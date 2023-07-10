/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import TDAS.ListaCircularDoble;
import java.time.LocalDate;

/**
 *
 * @author Dell
 */
public class Emoji {
    
    private String nombre;
    private String ruta;
    private LocalDate fechaCreacion;
    private ListaCircularDoble<String> partesEmoji;

    public Emoji(String nombre, String ruta, LocalDate fechaCreacion, ListaCircularDoble<String> partesEmoji) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.fechaCreacion = fechaCreacion;
        this.partesEmoji = partesEmoji;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ListaCircularDoble<String> getPartesEmoji() {
        return partesEmoji;
    }

    public void setPartesEmoji(ListaCircularDoble<String> partesEmoji) {
        this.partesEmoji = partesEmoji;
    }

    @Override
    public String toString() {
        return "Emoji{" + "nombre=" + nombre + ", ruta=" + ruta + ", fechaCreacion=" + fechaCreacion + ", partesEmoji=" + partesEmoji + '}';
    }
    
    
}
