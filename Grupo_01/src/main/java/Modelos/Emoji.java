package Modelos;

import TDAS.ListaCircularDoble;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un Emoji con nombre, ruta de imagen, fecha de creación 
 * y sus partes (rostro, ojos, boca).
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

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRuta() { return ruta; }
    public void setRuta(String ruta) { this.ruta = ruta; }

    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public ListaCircularDoble<String> getPartesEmoji() { 
        return partesEmoji; 
    }
    public void setPartesEmoji(ListaCircularDoble<String> partesEmoji) { 
        this.partesEmoji = partesEmoji; 
    }

    // — Métodos de comportamiento —

    /** Añade una nueva parte al emoji. */
    public void addParte(String parte) {
        partesEmoji.add(parte);
    }

    /** Elimina una parte existente. */
    public void removeParte(String parte) {
        partesEmoji.remove(parte);
    }

    /** Devuelve el número total de partes. */
    public int getNumeroPartes() {
        return partesEmoji.size();
    }

    /**
     * Retorna la lista de partes como un List<String>, construida manualmente
     * porque ListaCircularDoble no implementa stream().
     */
    public List<String> getPartesAsList() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < partesEmoji.size(); i++) {
            lista.add(partesEmoji.get(i));
        }
        return lista;
    }

    /** Un resumen legible del Emoji. */
    public String summary() {
        return String.format("Emoji '%s' creado el %s con %d partes",
                             nombre, fechaCreacion, getNumeroPartes());
    }

    @Override
    public String toString() {
        return "Emoji{" +
               "nombre='" + nombre + '\'' +
               ", ruta='" + ruta + '\'' +
               ", fechaCreacion=" + fechaCreacion +
               ", partesEmoji=" + getPartesAsList() +
               '}';
    }
}
