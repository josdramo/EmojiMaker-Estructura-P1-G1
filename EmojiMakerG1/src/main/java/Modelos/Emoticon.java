/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Enums.EmojiComponentType;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author infrative
 */
public class Emoticon extends Model {
    private HashMap<EmojiComponentType, EmojiComponent> componentes;
    private Stack<EmojiComponent> historial;
    
    public Emoticon() {
        componentes = new HashMap();
        historial = new Stack();
    }
    
    public void updateComponent(EmojiComponentType type, EmojiComponent component) {
        EmojiComponent componentePrevio = componentes.get(type);
        
        if (componentePrevio != null) {
            historial.add(componentePrevio);
        }
        
        componentes.put(type, component);
    }
    
    public EmojiComponent getComponent(EmojiComponentType type) {
        return componentes.get(type);
    }
    
    public void restoreLastChange() {
        if (!historial.isEmpty()) {
            EmojiComponent ultimoCambio = historial.pop();
            
            if (ultimoCambio instanceof Face) {
                componentes.put(EmojiComponentType.FACE, ultimoCambio);
            }
            
            if (ultimoCambio instanceof Mouth) {
                componentes.put(EmojiComponentType.MOUTH, ultimoCambio);
            }
            
            if (ultimoCambio instanceof Mirada) {
                componentes.put(EmojiComponentType.MIRADA, ultimoCambio);
            }
        }
    }
}
