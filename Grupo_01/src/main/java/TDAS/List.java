/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TDAS;

import java.io.Serializable;

/**
 *
 * @author Dell
 * @param <T>
 */
public interface List<T> extends Serializable {
    void add(T data);
    
    void remove(T data);
    
    int size();
    
    boolean isEmpty();
    
    T get(int index);
    
    boolean contains(T data);
    
    void removeByIndex(int index);
}
