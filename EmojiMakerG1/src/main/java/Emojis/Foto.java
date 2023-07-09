/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emojis;

import java.time.LocalDate;

/**
 *
 * @author Dell
 */
public class Foto {
    //nombre, ruta, tipo, una fecha de agregacion e informacion
    private String nombre;
    private String ruta;
    private LocalDate fechaAgregado;
    private String info;

    public Foto(String nombre, String ruta, LocalDate fechaAgregado, String info) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.fechaAgregado = fechaAgregado;
        this.info = info;
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

    public LocalDate getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(LocalDate fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Foto{" + "nombre=" + nombre + ", ruta=" + ruta + ", fechaAgregado=" + fechaAgregado + ", info=" + info + '}';
    }
    
    
}
