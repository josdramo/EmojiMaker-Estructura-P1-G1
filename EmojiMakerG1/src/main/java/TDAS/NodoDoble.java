/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAS;

/**
 *
 * @author Dell
 * @param <E>
 */
public class NodoDoble<E> {
    private E element;
    private NodoDoble<E> next;
    private NodoDoble<E> prev;
    
    public NodoDoble(E element){
        this.element = element;
        this.next = null;
        this.prev = null;
    }
    
    public NodoDoble(E element, NodoDoble<E> next, NodoDoble<E> prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public NodoDoble<E> getNext() {
        return next;
    }

    public void setNext(NodoDoble<E> next) {
        this.next = next;
    }

    public NodoDoble<E> getPrev() {
        return prev;
    }

    public void setPrev(NodoDoble<E> prev) {
        this.prev = prev;
    }
    
}
