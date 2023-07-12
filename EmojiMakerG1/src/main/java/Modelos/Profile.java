/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import TDAS.List;
import TDAS.ListaCircularDoble;

/**
 *
 * @author infrative
 */
public class Profile extends Model {
    
    private List<Emoticon> emoticones;
    private Usuario usuario;

    public Profile(Usuario usuario) {
        this.usuario = usuario;
        emoticones = new ListaCircularDoble();
    }

    public Profile(List<Emoticon> emoticones, Usuario usuario) {
        this(usuario);
        this.emoticones = emoticones;
    }

    public List<Emoticon> getEmoticones() {
        return emoticones;
    }

    public void setEmoticones(List<Emoticon> emoticones) {
        this.emoticones = emoticones;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
