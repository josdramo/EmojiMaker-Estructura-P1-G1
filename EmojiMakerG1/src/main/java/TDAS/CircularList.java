/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TDAS;

/**
 *
 * @author infrative
 */
public interface CircularList<T> extends List<T> {
    T next(T data);
    T prev(T data);
}
