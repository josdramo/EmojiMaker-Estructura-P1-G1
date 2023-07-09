/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TDAS;

/**
 *
 * @author Dell
 * @param <E>
 */
public interface List<E> {
    
    public int size();

    public boolean isEmpty();

    public void clear();

    public boolean addFirst(E element); 

    public boolean addLast(E element); 
    
    public E removeFirst();
    
    public E removeLast();
    
    public E remove(int index); 

    public E get(int index);
    
    public E set(int index, E element); 
    
    public void removeAll(E element);
    
}
