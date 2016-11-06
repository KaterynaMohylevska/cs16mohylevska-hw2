package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    Queue q = new Queue(1);
    Queue q1 = new Queue();

    @Test
    public void testEnqueue() {
        q.enqueue(3);
        assertEquals("[1, 3]", q.toString());

        q1.enqueue(3);
        assertEquals("[3]", q1.toString());
    }

    @Test
    public void testPeek() {
        assertEquals(1, q.peek());
    }

    @Test
    public void testDequeue() {
        assertEquals(1, q.dequeue());
    }

}
