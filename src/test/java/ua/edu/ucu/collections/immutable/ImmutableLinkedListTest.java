package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import org.omg.CORBA.Object;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList emptylist = new ImmutableLinkedList();
    ImmutableLinkedList list = new ImmutableLinkedList(3);
    ImmutableLinkedList list1;

    @Test
    public void testGeneral() {
        assertEquals("[]", this.emptylist.toString());

        assertEquals("[3]", this.list.toString());
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList nList = this.emptylist.add(3);
        assertEquals("[3]", nList.toString());

        ImmutableLinkedList newList = this.list.add(5);
        assertEquals("[3, 5]", newList.toString());
    }

    @Test
    public void testAddToIndex() {
        ImmutableLinkedList newList = this.list.add(0, 1);
        assertEquals("[1, 3]", newList.toString());
    }

    @Test
    public void testAddAll() {
        Integer[] o = {1, 2, 3};
        ImmutableLinkedList newList1 = this.list.addAll(o);
        assertEquals("[3, 1, 2, 3]", newList1.toString());

        ImmutableLinkedList newList = this.emptylist.addAll(o);
        assertEquals("[1, 2, 3]", newList.toString());

    }

    @Test
    public void testAddAllToIndex() {
        Integer[] o = {1, 2, 3};
        ImmutableLinkedList list2 = this.list.addAll(0, o);
        assertEquals("[1, 2, 3, 3]", list2.toString());
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testException() {
        ImmutableLinkedList newList = this.list.add(4, 1);

        Integer[] o = {1, 2, 3};
        ImmutableLinkedList newList1 = this.list.addAll(2, o);

        list.get(3);
        list.remove(3);
    }

    @Test
    public void testGet() {
        assertEquals("3", list.get(0).toString());
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList newList = list.remove(0);
        assertEquals("[]", newList.toString());
    }

    @Test
    public void testSet() {
        assertEquals("[10]", list.set(0, 10).toString());
    }

    @Test
    public void testAddFirst() {
        list1 = list.addFirst(2);
        assertEquals("[2, 3]", list1.toString());
    }

    @Test
    public void testAddLast() {
        list1 = list.addLast(2);
        assertEquals("[3, 2]", list1.toString());
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, list.indexOf(3));
    }

    @Test
    public void testSize() {
        assertEquals(1, list.size());
    }

    @Test
    public void testgetFirst() {
        assertEquals(3, list.getFirst());
    }

    @Test
    public void testgetLast() {
        assertEquals(3, list.getLast());
    }

    @Test
    public void testRemoveFirst() {
        assertEquals("[]", list.removeFirst().toString());
    }

    @Test
    public void testRemoveLast() {
        assertEquals("[]", list.removeLast().toString());
    }

    @Test
    public void testEmpty() {
        assertEquals(true, emptylist.isEmpty());
    }

    @Test
    public void testClear() {
        assertEquals("[]", list.clear().toString());
    }

}
