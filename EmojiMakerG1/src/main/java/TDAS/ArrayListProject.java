/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAS;

/**
 *
 * @author Dell
 */
public class ArrayListProject<E> implements List<E> {

    private E[] elements;
    private int MAX_SIZE = 100;
    private int effectiveSize;

    public ArrayListProject() {
        elements = (E[]) new Object[MAX_SIZE];
        effectiveSize = 0;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }

        for (int i = effectiveSize; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }

        elements[effectiveSize++] = element;
        return true;
    }

    private boolean isFull() {
        return effectiveSize == MAX_SIZE;
    }

    public boolean add(E element, int index) {
        if (index < 0 || index > effectiveSize) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        for (int i = effectiveSize; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= effectiveSize) {
            return null;
        }
        return elements[index];
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    private void addCapacity() {
        MAX_SIZE = MAX_SIZE * 2;
        E[] newElements = (E[]) new Object[MAX_SIZE];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
    }

    @Override
    public void clear() {
        for (int i = 0; i < effectiveSize; i++) {
            elements[i] = null;
        }
        effectiveSize = 0;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E elementoRemovido = elements[0];

        for (int i = 0; i < effectiveSize - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[effectiveSize - 1] = null;
        effectiveSize--;

        return elementoRemovido;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        E elementoRemovido = elements[effectiveSize - 1];

        elements[effectiveSize - 1] = null;
        effectiveSize--;

        return elementoRemovido;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= effectiveSize) {
            return null;
        }

        E elementoRemovido = elements[index];

        for (int i = index; i < effectiveSize - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[effectiveSize - 1] = null;
        effectiveSize--;

        return elementoRemovido;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= effectiveSize || element == null) {
            return null;
        }

        E reemplazo = elements[index];
        elements[index] = element;

        return reemplazo;
    }

    @Override
    public void removeAll(E element) {
        if (element == null) {
            return;
        }

        for (int i = 0; i < effectiveSize; i++) {
            if (elements[i].equals(element)) {
                remove(i);
                i--;
            }
        }
    }

    @Override
    public E getNext(int index) {
        if (index < 0 || index >= effectiveSize) {
            return null;
        }

        int indiceSiguiente = (index + 1) % effectiveSize;

        return elements[indiceSiguiente];
    }

    @Override
    public E getPrev(int index) {
        if (index < 0 || index >= effectiveSize) {
            return null;
        }

        int indiceAnterior = (index - 1 + effectiveSize) % effectiveSize;

        return elements[indiceAnterior];
    }

    @Override
    public Boolean has(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
