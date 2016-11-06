package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    ImmutableLinkedList list;

    public Stack() {
        list = new ImmutableLinkedList();
    }

    public Stack(Object e) {
        list = new ImmutableLinkedList(e);
    }

    public void add(Object e) {
        list = list.add(e);
    }

    public Object peek() {
        return list.getLast();
    }

    public Object pop() {
        Object e = list.getLast();
        list = list.removeLast();
        return e;
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
