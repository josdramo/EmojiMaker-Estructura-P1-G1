/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAS;

import java.io.Serializable;

/**
 *
 * @author CltControl
 * @param <T>
 */
public class CircularArray<T> implements Serializable {
  private final T[] array;
  private int first;
  private int last;
  private int size;
  private final int capacity;

  public CircularArray(int capacity) {
    this.capacity = capacity;
    this.array = (T[]) new Object[capacity];
    this.first = -1;
    this.last = -1;
    this.size = 0;
  }

  public void addLast(T value) {
    if (isFull()) {
      removeFirst();
    }

    if (isEmpty()) {
      first = 0;
      last = 0;
    } else {
      last = (last + 1) % capacity;
    }

    array[last] = value;
    size++;
  }

  public void addFirst(T value) {
    if (isFull()) {
      removeLast();
    }

    if (isEmpty()) {
      first = 0;
      last = 0;
    } else {
      first = (first - 1 + capacity) % capacity;
    }

    array[first] = value;
    size++;
  }

  public void removeFirst() {
    if (isEmpty()) {
      throw new IllegalStateException("El vector está vacío");
    }

    if (first == last) {
      first = -1;
      last = -1;
    } else {
      first = (first + 1) % capacity;
    }

    size--;
  }

  public void removeLast() {
    if (isEmpty()) {
      throw new IllegalStateException("El vector está vacío");
    }

    if (first == last) {
      first = -1;
      last = -1;
    } else {
      last = (last - 1 + capacity) % capacity;
    }

    size--;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }

  public int getSize() {
    return size;
  }

  public T get(int index) {
    if (isEmpty()) {
      throw new IllegalStateException("El vector está vacío");
    }

    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Índice fuera de rango");
    }

    int actualIndex = (first + index) % capacity;
    return array[actualIndex];
  }
  
  public T getFirst() {
    if (isEmpty()) {
      throw new IllegalStateException("El vector está vacío");
    }

    return array[first];
  }

  public T getLast() {
    if (isEmpty()) {
      throw new IllegalStateException("El vector está vacío");
    }

    return array[last];
  }
}
