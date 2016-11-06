package ua.edu.ucu.collections.immutable;

import java.util.IllegalFormatException;

public class ImmutableLinkedList implements ImmutableList {

    private final static class Node {
        private Object data;
        private Node next;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(Object e) {
            this.data = e;
            this.next = null;
        }

        public Node clone() {
            return new Node(this.data);

        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }

    private Node head;

    public ImmutableLinkedList() {
        this.head = null;
    }

    public ImmutableLinkedList(Node e) {
        this.head = e;
    }

    public ImmutableLinkedList(Object e) {
        this.head = new Node(e);
    }


    @Override
    public ImmutableLinkedList add(Object e) {
        if (this.head == null) {
            return new ImmutableLinkedList(new Node(e));
        }

        Node h = this.head.clone();
        Node next = this.head.next;
        Node newElem = h;
        while (next != null) {
            newElem.setNext(next.clone());
            next = next.getNext();
            newElem = newElem.getNext();
        }

        newElem.setNext(new Node(e));
        return new ImmutableLinkedList(h);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        Node h;
        Node newElem;
        Node next;
        if (index == 0) {
            h = new Node(e);
            next = this.head;
            newElem = h;
        } else {
            h = this.head.clone();
            next = this.head.next;
            newElem = h;

            for (int i = 0; i < index - 1; i++) {
                if (next != null) {
                    newElem.setNext(next.clone());
                    next = next.getNext();
                    newElem = newElem.getNext();
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
            newElem.setNext(new Node(e));
            newElem = newElem.getNext();
        }


        while (next != null) {
            newElem.setNext(next.clone());
            next = next.getNext();
            newElem = newElem.getNext();
        }

        return new ImmutableLinkedList(h);
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        Object e = c[0];
        if (this.head == null) {
            Node h = new Node(e);
            Node newElem = h;
            for (int i = 1; i < c.length; i++) {
                newElem.setNext(new Node(c[i]));
                newElem = newElem.getNext();
            }
            return new ImmutableLinkedList(h);
        }

        Node h = this.head.clone();
        Node next = this.head.next;
        Node newElem = h;
        while (next != null) {
            newElem.setNext(next.clone());
            next = next.getNext();
            newElem = newElem.getNext();
        }

        newElem.setNext(new Node(e));
        newElem = newElem.getNext();

        for (int i = 1; i < c.length; i++) {
            newElem.setNext(new Node(c[i]));
            newElem = newElem.getNext();
        }
        return new ImmutableLinkedList(h);

    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        Node h;
        Node newElem;
        Node next;
        Object e = c[0];
        if (index == 0) {
            h = new Node(e);
            newElem = h;
            for (int i = 1; i < c.length; i++) {
                newElem.setNext(new Node(c[i]));
                newElem = newElem.getNext();
            }
            next = this.head;
        } else {
            h = this.head.clone();
            next = this.head.next;
            newElem = h;

            for (int i = 0; i < index - 1; i++) {
                if (next != null) {
                    newElem.setNext(next.clone());
                    next = next.getNext();
                    newElem = newElem.getNext();
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
            newElem.setNext(new Node(e));
            newElem = newElem.getNext();
            for (int i = 1; i < c.length; i++) {
                newElem.setNext(new Node(c[i]));
                newElem = newElem.getNext();
            }
        }


        while (next != null) {
            newElem.setNext(next.clone());
            next = next.getNext();
            newElem = newElem.getNext();
        }

        return new ImmutableLinkedList(h);
    }

    @Override
    public Object get(int index) {
        Node elem = this.head;
        for (int i = 0; i < index; i++) {
            if (elem != null) {
                elem = elem.next;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        return elem.data;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        if (index == 0 && this.head.next == null) {
            return new ImmutableLinkedList();
        }

        Node h = this.head.clone();
        Node next = this.head.next;
        Node newElem = h;

        for (int i = 0; i < index - 1; i++) {
            if (next != null) {
                newElem.setNext(next.clone());
                next = next.getNext();
                newElem = newElem.getNext();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        next = next.getNext();
        while (next != null) {
            newElem.setNext(next.clone());
            newElem = newElem.getNext();
            next = next.getNext();
        }


        return new ImmutableLinkedList(h);

    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        Node h;
        if (index == 0){
            h = new Node(e);
            if (this.head.next == null){
                return new ImmutableLinkedList(h);
            }
        }
        else {
            h = this.head.clone();
        }
        Node next = this.head.next;
        Node newElem = h;

        for (int i = 0; i < index - 1; i++) {
            if (next != null) {
                newElem.setNext(next.clone());
                next = next.getNext();
                newElem = newElem.getNext();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        newElem.setNext(new Node(e));
        next = next.getNext();
        newElem = newElem.getNext();

        while (next != null) {
            newElem.setNext(next.clone());
            next = next.getNext();
            newElem = newElem.getNext();
        }


        return new ImmutableLinkedList(h);
    }

    @Override
    public int indexOf(Object e) {
        Node elem = this.head;
        int index = 0;
        while (elem != null) {
            if (elem.data == e) {
                return index;
            }
            index += 1;
            elem = elem.next;
        }
        return -1;
    }

    @Override
    public int size() {
        Node elem = this.head;
        int size = 0;
        while (elem != null) {
            size += 1;
            elem = elem.next;
        }
        return size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        int len = this.size();
        Object[] arr = new Object[len];
        Node elem = this.head;
        for (int i = 0; i < len; i++) {
            arr[i] = elem;
            elem = elem.next;
        }
        return arr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Node h;
        Node newElem;
        Node next;
        h = new Node(e);
        next = this.head;
        newElem = h;
        while (next != null) {
            newElem.setNext(next.clone());
            next = next.getNext();
            newElem = newElem.getNext();
        }

        return new ImmutableLinkedList(h);

    }

    public ImmutableLinkedList addLast(Object e) {
        if (this.head == null) {
            this.head = new Node(e);
            return this;
        }

        Node h = this.head.clone();
        Node next = this.head.next;
        Node newElem = h;
        while (next != null) {
            newElem.setNext(next.clone());
            next = next.getNext();
            newElem = newElem.getNext();
        }

        newElem.setNext(new Node(e));
        return new ImmutableLinkedList(h);
    }

    public Object getFirst() {
        return this.head.data;
    }

    public Object getLast() {
        Node elem = this.head;
        while (elem.next != null) {
            elem = elem.next;
        }
        return elem.data;
    }

    public ImmutableLinkedList removeFirst() {
        ImmutableLinkedList lst = this.remove(0);
        return lst;
    }

    public ImmutableLinkedList removeLast() {
        ImmutableLinkedList lst = this.remove(this.size() - 1);
        return lst;
    }

    public String toString() {
        if (this.head == null) {
            return "[]";
        }
        String str = "[";
        Node n = this.head;
        str += this.head.toString();
        while (n.next != null) {
            str += ", " + n.getNext().toString();
            n = n.getNext();
        }
        str += "]";
        return str;
    }

}

