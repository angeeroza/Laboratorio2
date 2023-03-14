package colaDoble;

import java.util.Comparator;

public interface DoubleEndedQueue<T> {

    // Basic operations

    void prepend(T value);
    void append(T value);
    void deleteFirst();
    void deleteLast();
    T first();
    T last();
    int size();

    // Complex operations

    T get(int index);
    boolean contains(T value);
    void remove(T value);
    void sort(Comparator<? super T> comparator);
}