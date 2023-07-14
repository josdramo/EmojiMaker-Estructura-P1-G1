/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Enums.EmojiComponentType;
import TDAS.CircularList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author infrative
 */
public class Emoticon extends Model {
    private HashMap<EmojiComponentType, String> componentes;
    private Stack<String> historial;
    
    public Emoticon() {
        componentes = new HashMap();
        historial = new Stack();
    }
    
    public void updateComponent(EmojiComponentType type, String component) {
        String componentePrevio = componentes.get(type);
        
        if (componentePrevio != null) {
            historial.add(componentePrevio);
        }
        
        componentes.put(type, component);
    }
    
    public String getComponent(EmojiComponentType type) {
        return componentes.get(type);
    }
    
    public void restoreLastChange(Map<EmojiComponentType, CircularList<String>> componentesParaComprobar) {
        if (!historial.isEmpty()) {
            String ultimoCambio = historial.pop();
            
            if (componentesParaComprobar.get(EmojiComponentType.FACE).contains(ultimoCambio)) {
                componentes.put(EmojiComponentType.FACE, ultimoCambio);
            }
            
            else if (componentesParaComprobar.get(EmojiComponentType.MIRADA).contains(ultimoCambio)) {
                componentes.put(EmojiComponentType.MIRADA, ultimoCambio);
            }
            
            else if (componentesParaComprobar.get(EmojiComponentType.MIRADA).contains(ultimoCambio)) {
                componentes.put(EmojiComponentType.MIRADA, ultimoCambio);
            }
        }
    }
    
    public Boolean isEmpty() {
        return componentes.isEmpty();
    }
}
