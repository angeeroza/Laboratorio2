package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        DequeNode<T> Nodo = new DequeNode<>(value, null, first);
        if (size == 0){
            this.first = Nodo;
            this.last = Nodo;
        } else{
            this.first.setPrevious(Nodo);
            this.first = Nodo;
        }
        size++;
    }

    @Override
    public void append(T value) {
        DequeNode<T> Nodo = new DequeNode<>(value, last, null);
        if (size == 0){
            this.first = Nodo;
            this.last = Nodo;
        } else{
            this.last.setNext(Nodo);
            this.last = Nodo;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if (size > 1){
           first = first.getNext();
           first.setPrevious(null);
        } else if (size == 1){
            first = null;
            last = null;
        }
        size--;
    }

    @Override
    public void deleteLast() {
        if (size > 1){
            last = last.getPrevious();
            last.setNext(null);
        } else if (size == 1){
            first = null;
            last = null;
        }
        size--;
    }

    @Override
    public T first() {
        return first.getItem();
    }

    @Override
    public T last() {
        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }
}
