package collections.linkedlist;

import java.util.Iterator;

public interface Linked<E> {
    void addLast (E e);
    void addFirst (E e);
    int size();
    E getElementByIndex(int counter);

    Iterator<E> iterator();
}
