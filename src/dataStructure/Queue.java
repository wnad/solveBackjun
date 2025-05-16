package dataStructure;

import java.util.LinkedList;
import java.util.Iterator;

public class Queue<E> implements QueueInterface<E>, Iterable<E> {

    private LinkedList<E> list;

    public Queue() {
        list = new LinkedList<>();
    }

    @Override
    public boolean add(E element) {
        return list.add(element);
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return list.removeFirst();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
