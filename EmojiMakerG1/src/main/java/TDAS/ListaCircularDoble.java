/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAS;

import Excepciones.UnderflowException;

/**
 *
 * @author Dell
 * @param <E>
 */
public class ListaCircularDoble<E> implements List<E> {

    private NodoDoble<E> first;
    private NodoDoble<E> last;

    public ListaCircularDoble() {
        this.first = null;
        this.last = null;
    }

    @Override
    public int size() {
        int cont = 0;
        NodoDoble<E> viajero;
        for (viajero = first; viajero != null; viajero = viajero.getNext()) {
            cont++;
        }
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        }
        NodoDoble<E> nodoNuevo = new NodoDoble<>(element);
        nodoNuevo.setNext(this.first);
        if (this.isEmpty()) {
            this.last = nodoNuevo;
        }
        this.first = nodoNuevo;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }
        NodoDoble<E> nodoNuevo = new NodoDoble<>(element);
        if (this.isEmpty()) {
            this.first = nodoNuevo;
        } else {
            this.last.setNext(nodoNuevo);
        }
        this.last = nodoNuevo;
        return true;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new UnderflowException("No se puede remover elementos a una lista vacía");
        }
        E element = first.getElement();
        first = first.getNext();
        first.setPrev(last);
        last.setNext(first);
        return element;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new UnderflowException("No se puede remover elementos a una lista vacía");
        }

        E element = last.getElement();
        last = last.getPrev();
        last.setNext(first);
        first.setPrev(last);
        return element;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size() - 1) {
            return removeLast();
        } else {
            NodoDoble<E> nodoEliminar = first;
            for (int i = 0; i < index; i++) {
                nodoEliminar = nodoEliminar.getNext();
            }
            E element = nodoEliminar.getElement();
            removeNode(nodoEliminar);
            return element;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        NodoDoble<E> nodoActual = first;
        for (int i = 0; i < index; i++) {
            nodoActual = nodoActual.getNext();
        }
        return nodoActual.getElement();
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        NodoDoble<E> nodoActual = first;
        for (int i = 0; i < index; i++) {
            nodoActual = nodoActual.getNext();
        }
        E elementoAnterior = nodoActual.getElement();
        nodoActual.setElement(element);
        return elementoAnterior;
    }

    @Override
    public void removeAll(E element) {
        NodoDoble<E> viajero = first;

        while (viajero != null) {
            if (viajero.getElement().equals(element)) {
                viajero = removeNode(viajero);
            } else {
                viajero = viajero.getNext();
            }
        }
    }

    private NodoDoble<E> removeNode(NodoDoble<E> node) {
        NodoDoble<E> nextNode = node.getNext();
        NodoDoble<E> prevNode = node.getPrev();

        if (node == first) {
            first = nextNode;
        } else {
            prevNode.setNext(nextNode);
        }

        if (node == last) {
            last = prevNode;
        } else {
            nextNode.setPrev(prevNode);
        }
        return nextNode;
    }

    @Override
    public String toString() {
        String result = "{";
        NodoDoble<E> p;
        for (p = first; p != null; p = p.getNext()) {

            result += p.getElement() + ", ";
        }
        if (!isEmpty()) {
            result = result.substring(0, result.length() - 2);
        }
        return result + "}";
    }

    @Override
    public E getNext(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        NodoDoble<E> nodoActual = first;
        for (int i = 0; i < index; i++) {
            nodoActual = nodoActual.getNext();
        }
        NodoDoble<E> siguienteNodo = nodoActual.getNext();

        if (siguienteNodo == null) {
            return first.getElement();
        } else {
            return siguienteNodo.getElement();
        }
    }

    @Override
    public E getPrev(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        NodoDoble<E> nodoActual = first;
        for (int i = 0; i < index; i++) {
            nodoActual = nodoActual.getNext();
        }
        NodoDoble<E> nodoAnterior = nodoActual.getPrev();

        if (nodoAnterior == null) {
            return last.getElement();
        } else {
            return nodoAnterior.getElement();
        }
    }
}
