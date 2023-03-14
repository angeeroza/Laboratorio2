package colaDoble;

/**
 * Esta clase representa un nodo de una lista doblemente enlazada. Cada nodo tiene una referencia a su
 * elemento, así como a los nodos anteriores y siguientes.
 *
 * @param <T> el tipo de elemento almacenado en el nodo.
 */
class DequeNode<T> {
    private T item;
    private DequeNode<T> previous;
    private DequeNode<T> next;

    /**
     * Crea un nuevo nodo con el elemento especificado, el nodo anterior y el nodo siguiente.
     *
     * @param item     el elemento almacenado en este nodo.
     * @param previous el nodo anterior a este nodo.
     * @param next     el nodo siguiente a este nodo.
     */
    DequeNode(T item, DequeNode<T> previous, DequeNode<T> next) {
        this.item = item;
        this.previous = previous;
        this.next = next;
    }

    /**
     * Devuelve el elemento almacenado en este nodo.
     *
     * @return el elemento almacenado en este nodo.
     */
    T getItem() {
        return item;
    }

    /**
     * Establece el elemento almacenado en este nodo.
     *
     * @param item el nuevo elemento a almacenar en este nodo.
     */
    void setItem(T item) {
        this.item = item;
    }

    /**
     * Devuelve el nodo anterior a este nodo.
     *
     * @return el nodo anterior a este nodo.
     */
    DequeNode<T> getPrevious() {
        return previous;
    }

    /**
     * Establece el nodo anterior a este nodo.
     *
     * @param previous el nuevo nodo anterior a este nodo.
     */
    void setPrevious(DequeNode<T> previous) {
        this.previous = previous;
    }

    /**
     * Devuelve el nodo siguiente a este nodo.
     *
     * @return el nodo siguiente a este nodo.
     */
    DequeNode<T> getNext() {
        return next;
    }

    /**
     * Establece el nodo siguiente a este nodo.
     *
     * @param next el nuevo nodo siguiente a este nodo.
     */
    void setNext(DequeNode<T> next) {
        this.next = next;
    }

    /**
     * Devuelve verdadero si este nodo es el primer nodo de la lista.
     *
     * @return verdadero si este nodo es el primer nodo de la lista, falso de lo contrario.
     */
    boolean isFirstNode() {
        return previous == null;
    }

    /**
     * Devuelve verdadero si este nodo es el último nodo de la lista.
     *
     * @return verdadero si este nodo es el último nodo de la lista, falso de lo contrario.
     */
    boolean isLastNode() {
        return next == null;
    }

    /**
     * Devuelve verdadero si este nodo no es el primer ni el último nodo de la lista.
     *
     * @return verdadero si este nodo no es el primer ni el último nodo de la lista, falso de lo contrario.
     */
    boolean isNotATerminalNode() {
        return !(isFirstNode() || isLastNode());
    }
}