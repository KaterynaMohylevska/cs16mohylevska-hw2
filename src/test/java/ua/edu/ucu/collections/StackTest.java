package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    Stack s = new Stack(1);
    Stack s1 = new Stack();

    @Test
    public void testAdd() {
        s.add(3);
        assertEquals("[1, 3]", s.toString());


        s1.add(3);
        assertEquals("[3]", s1.toString());
    }

    @Test
    public void testPeek() {
        s.add(4);
        assertEquals(4, s.peek());
    }

    @Test
    public void testDequeue() {
        s.add(4);
        assertEquals(4, s.pop());
    }

}
