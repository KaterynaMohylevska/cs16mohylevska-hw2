package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList list;

    public Queue() {
        list = new ImmutableLinkedList();
    }

    public Queue(Object e) {
        list = new ImmutableLinkedList(e);
    }

    public Object peek() {
        return list.getFirst();
    }

    public Object dequeue() {
        Object e = list.getFirst();
        list = list.removeFirst();
        return e;
    }

    public void enqueue(Object e) {
        list = list.add(e);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
