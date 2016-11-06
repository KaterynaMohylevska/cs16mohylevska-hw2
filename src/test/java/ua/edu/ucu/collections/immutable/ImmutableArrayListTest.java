package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableArrayList list1 = new ImmutableArrayList();
    ImmutableArrayList list = new ImmutableArrayList(2);

    @Test
    public void testaAdd() {
        ImmutableArrayList l = list.add(1);
        assertEquals("[2, 1]", l.toString());
    }

    @Test
    public void testaAddtoIndex() {
        ImmutableArrayList l = list.add(0, 1);
        assertEquals("[1, 2]", l.toString());
    }

    @Test
    public void testaAddAll() {
        Integer[] a = {1, 3, 4};
        ImmutableArrayList l = list.addAll(a);
        assertEquals("[2, 1, 3, 4]", l.toString());
    }

    @Test
    public void testaAddAlltoIndex() {
        Integer[] a = {1, 3, 4};
        ImmutableArrayList l = list.addAll(0, a);
        assertEquals("[1, 3, 4, 2]", l.toString());
    }

    @Test
    public void testRemove() {
        Integer[] a = {1, 3, 4};
        ImmutableArrayList l = list.addAll(0, a);

        assertEquals("[1, 3, 2]", l.remove(2).toString());
    }

    @Test
    public void testSet() {
        Integer[] a = {1, 3, 4};
        ImmutableArrayList l = list.addAll(0, a);

        assertEquals("[1, 3, 4, 10]", l.set(3, 10).toString());
    }

    @Test
    public void testInddex() {
        Integer[] a = {1, 3, 4};
        ImmutableArrayList l = list.addAll(0, a);

        assertEquals(1, l.indexOf(3));
    }

    @Test
    public void testSize() {
        assertEquals(1, list.size());
    }

    @Test
    public void testGet() {
        assertEquals(2, list.get(0));
    }

    @Test
    public void testClear() {
        assertEquals("[]", list.clear().toString());
    }

    @Test
    public void testEmpty() {
        assertEquals(true, list1.isEmpty());
    }

}
