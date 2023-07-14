/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAS;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author infrative
 */
public class ArrayList<T> implements List<T>, Serializable, Iterable<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] elements;
    private int size;

    public ArrayList() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    @Override
    public void add(T data) {
        if (size == elements.length) {
            expandCapacity();
        }
        elements[size] = data;
        size++;
    }

    @Override
    public void remove(T data) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                removeByIndex(i);
                break;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) elements[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

    @Override
    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeByIndex(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
            size--;
        } else {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
    
    public void update(int index, T data) {
        if (index >= 0 && index < size) {
            elements[index] = data;
        } else {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

    private void expandCapacity() {
        int newCapacity = elements.length * 2;
        T[] newElements = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex;

        public ArrayListIterator() {
            this.currentIndex = 0;
        }

        public boolean hasNext() {
            return currentIndex < size;
        }

        public T next() {
            if (hasNext()) {
                T element = (T) elements[currentIndex];
                currentIndex++;
                return element;
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported.");
        }
    }
}
