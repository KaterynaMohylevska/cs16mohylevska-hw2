package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList{

    private final class Node {
        private Object data;
        private Node next;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        public Node(){
            this.data = null;
            this.next = null;
        }

        public Node(Object e) {
            this.data = e;
            this.next = null;
        }

        public Node clone(){
            return new Node(this.data);

        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }

    private Node head;

    public ImmutableLinkedList(){
        this.head = null;
    }

    public ImmutableLinkedList(Node e){
        this.head = e;
    }

    public ImmutableLinkedList(Object e){
        this.head = new Node(e);
    }


    @Override
    public ImmutableList add(Object e) {
        if (this.head == null){
            this.head = new Node(e);
            return this;
        }

        Node h = this.head.clone();
        Node next = this.head.next;
        Node newElem = h;
        while (next != null ){
            newElem.setNext(next.clone());
            next = next.getNext();
            newElem = newElem.getNext();
        }

        newElem.setNext(new Node(e));
        return new ImmutableLinkedList(h);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return null;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return null;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ImmutableList clear() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    //public ImmutableLinkedList addFirst(Object e){}

    //public ImmutableLinkedList addLast(Object e){}

    //public Object getFirst(){}
    //public Object getLast(){}

    //public ImmutableLinkedList removeFirst(){}
    //public ImmutableLinkedList removeLast({}

    public String toString(){
        if (this.head == null){
            return "[]";
        }
        String str = "[";
        Node n = this.head;
        str += this.head.toString();
        while (n.next != null){
            str += ", " + n.getNext().toString();
            n = n.getNext();
        }
        str += "]";
        return str;
    }

}

