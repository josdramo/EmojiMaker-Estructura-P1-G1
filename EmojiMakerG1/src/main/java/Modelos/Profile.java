/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Enums.EmojiComponentType;
import TDAS.List;
import TDAS.ListaCircularDoble;
import java.util.Map;

/**
 *
 * @author infrative
 */
public class Profile extends Model {
    
    private List<Emoticon> emoticones;
    private Usuario usuario;
    private Map<EmojiComponentType, ListaCircularDoble<String>> componentes;

    public Profile(Usuario usuario) {
        this.usuario = usuario;
        emoticones = new ListaCircularDoble();
    }

    public Profile(List<Emoticon> emoticones, Usuario usuario) {
        this(usuario);
        this.emoticones = emoticones;
    }
    
    public Profile(Usuario usuario, Map<EmojiComponentType, ListaCircularDoble<EmojiComponent>> componentes) {
        this(usuario);
        this.componentes = componentes;
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

    public Map<EmojiComponentType, ListaCircularDoble<EmojiComponent>> getComponentes() {
        return componentes;
    }
    
}
