package colaDoble;

import java.util.Comparator;

/**

 Implementación de una lista doblemente enlazada que permite agregar y eliminar elementos tanto al inicio como al final.

 @param <T> el tipo de dato que se va a almacenar en la lista.
 */
public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    /**
     Crea una nueva lista doblemente enlazada vacía.
     */
    public DoublyLinkedListDeque() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    /**
     Agrega un elemento al inicio de la lista.
     @param value el elemento a agregar.
     */
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

    /**
     Agrega un elemento al final de la lista.
     @param value el elemento a agregar.
     */
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

    /**
     Elimina el primer elemento de la lista.
     */
    @Override
    public void deleteFirst() {
        if (size > 1){
            first = first.getNext();
            first.setPrevious(null);
        } else if (size == 1){
            first = null;
            last = null;
        } else {
            throw new DoubleEndedQueueException("No puedes eliminar elementos de una lista vacia");
        }
        size--;
    }

    /**
     Elimina el último elemento de la lista.
     */
    @Override
    public void deleteLast() {
        if (size > 1){
            last = last.getPrevious();
            last.setNext(null);
        } else if (size == 1){
            first = null;
            last = null;
        } else {
            throw new DoubleEndedQueueException("No puedes eliminar elementos de una lista vacia");
        }
        size--;
    }

    /**
     Devuelve el primer elemento de la lista.
     @return el primer elemento de la lista.
     */
    @Override
    public T first() {
        return first.getItem();
    }

    /**
     Devuelve el nodo que representa al primer elemento de la lista.
     @return el nodo que representa al primer elemento de la lista.
     */
    public DequeNode<T> getFirst() {
        return first;
    }

    /**
     Devuelve el nodo que representa al último elemento de la lista.
     @return el nodo que representa al último elemento de la lista.
     */
    public DequeNode<T> getLast() {
        return last;
    }

    /**
     Devuelve el último elemento de la lista.
     @return el último elemento de la lista.
     */
    @Override
    public T last() {
        return last.getItem();
    }

    /**
     Devuelve el tamaño actual de la cola.
     @return Tamaño actual de la cola.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     Devuelve el elemento de la cola que se encuentra en la posición indicada.
     @param index Índice del elemento a devolver.
     @return Elemento de la cola que se encuentra en la posición indicada.
     @throws DoubleEndedQueueException Si el índice indicado es mayor que el tamaño de la lista.
     */
    @Override
    public T get(int index) throws DoubleEndedQueueException {
        if(index > size){
            throw new DoubleEndedQueueException("El indice indicado es mayor que el tamaño de la lista");
        } else {
            DequeNode<T> aux = first;
            for(int i = 0; i < index; i++){
                aux = aux.getNext();
            }
            return aux.getItem();
        }
    }

    /**
     Comprueba si la cola contiene el elemento indicado.
     @param value Elemento a buscar en la cola.
     @return True si la cola contiene el elemento indicado, false en caso contrario.
     @throws DoubleEndedQueueException Si el valor a buscar es null.
     */
    @Override
    public boolean contains(T value) throws DoubleEndedQueueException {
        if(value == null){
            throw new DoubleEndedQueueException("El valor a buscar no puede ser null");
        } else {
            DequeNode<T> aux = first;
            for(int i = 0; i < size; i++){
                if(aux.getItem() == value){
                    return true;
                }
                aux = aux.getNext();
            }
            return false;
        }
    }

    /**
     Elimina el primer elemento de la cola que sea igual al elemento indicado.
     @param value Elemento a eliminar de la cola.
     @throws DoubleEndedQueueException Si el valor a buscar es null o si la cola está vacía.
     */
    @Override
    public void remove(T value) throws DoubleEndedQueueException {
        if(value == null){
            throw new DoubleEndedQueueException("El valor a buscar no puede ser null");
        } else {
            if(first.getItem() == value){
                first = first.getNext();
                first.setPrevious(null);
            }else if(last.getItem() == value){
                last = last.getPrevious();
                last.setNext(null);
            } else {
                DequeNode<T> aux = first;
                for(int i = 0; i < size; i++){
                    if(aux.getItem() == value){
                        aux.getPrevious().setNext(aux.getNext());
                        aux.getNext().setPrevious(aux.getPrevious());
                    }
                    aux = aux.getNext();
                }
            }
            size--;
        }
    }

    /**
     Ordena la lista utilizando un comparador dado.
     @param comparator el comparador utilizado para ordenar la lista.
     @throws DoubleEndedQueueException si la lista tiene menos de dos elementos.
     */
    public void sort(Comparator<? super T> comparator) throws DoubleEndedQueueException {
        if (size < 2) {
            throw new DoubleEndedQueueException("No se puede ordenar una lista de 1 elemento");
        }

        boolean swapped;
        do {
            swapped = false;
            DequeNode<T> current = first;
            while (current.getNext() != null) {
                DequeNode<T> next = current.getNext();
                if (comparator.compare(current.getItem(), next.getItem()) > 0) {
                    swapped = true;
                    swapNodes(current, next);
                } else {
                    current = current.getNext();
                }
            }
        } while (swapped);
    }

    /**
     Intercambia los elementos de dos nodos dados.
     @param node1 el primer nodo.
     @param node2 el segundo nodo.
     */
    private void swapNodes(DequeNode<T> node1, DequeNode<T> node2) {
        T temp = node1.getItem();
        node1.setItem(node2.getItem());
        node2.setItem(temp);
    }
}
