package sree.datastructures;

import java.util.Iterator;
import java.util.LinkedList;

public class AdvancedQueueWithLinkedList<T> implements Iterable<T> {

    public java.util.LinkedList<T> list = new LinkedList<>();

    public AdvancedQueueWithLinkedList(T firstElement) {

    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void enQueue(T element) {
        list.addLast(element);
    }

    public T deQueue() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return list.removeFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
