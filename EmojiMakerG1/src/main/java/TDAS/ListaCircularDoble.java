/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAS;

import java.io.Serializable;

/**
 *
 * @author Dell
 * @param <T>
 */
public class ListaCircularDoble<T> implements CircularList<T>, Serializable {
    
    private Node<T> head;
    private int size;

    private static class Node<T> implements Serializable {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            
            prev = null;
            next = null;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node<T> lastNode = head.prev;

            newNode.next = head;
            newNode.prev = lastNode;

            head.prev = newNode;
            lastNode.next = newNode;
        }

        size++;
    }

    public void remove(T data) {
        if (head == null) {
            return;
        }

        Node<T> currentNode = head;
        Node<T> prevNode = null;

        while (currentNode.data != data) {
            if (currentNode.next == head) {
                return;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode == head && currentNode.next == head) {
            head = null;
        } else if (currentNode == head) {
            Node<T> lastNode = head.prev;
            head = head.next;

            lastNode.next = head;
            head.prev = lastNode;
        } else {
            prevNode.next = currentNode.next;
            currentNode.next.prev = prevNode;
        }

        size--;
    }

    public void printList() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Node<T> currentNode = head;

        do {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        } while (currentNode != head);

        System.out.println();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public T next(T data) {
        if (head == null) {
            return null;
        }
        
        Node<T> currentNode = head;
        
        do {
            if (currentNode.data.equals(data)) {
                return currentNode.next.data;
            }
            
            currentNode = currentNode.next;
        } while (currentNode != head);
        
        return null;
    }
    
    public T prev(T data) {
        if (head == null) {
            return null;
        }
        
        Node<T> currentNode = head;
        
        do {
            if (currentNode.data.equals(data)) {
                return currentNode.prev.data;
            }
            
            currentNode = currentNode.next;
        } while (currentNode != head);
        
        return null;
    }
    
    public T get(int index) {
        if (head == null || index < 0 || index >= size) {
            return null;
        }
        
        Node<T> currentNode = head;
        
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        
        return currentNode.data;
    }
    
    public boolean contains(T data) {
        if (head == null) {
            return false;
        }
        
        Node<T> currentNode = head;
        
        do {
            if (currentNode.data.equals(data)) {
                return true;
            }
            
            currentNode = currentNode.next;
        } while (currentNode != head);
        
        return false;
    }
    
    public void removeByIndex(int index) {
        if (head == null || index < 0 || index >= size) {
            return;
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode == head && currentNode.next == head) {
            head = null;
        } else if (currentNode == head) {
            Node<T> lastNode = head.prev;
            head = head.next;

            lastNode.next = head;
            head.prev = lastNode;
        } else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }

        size--;
    }
}
