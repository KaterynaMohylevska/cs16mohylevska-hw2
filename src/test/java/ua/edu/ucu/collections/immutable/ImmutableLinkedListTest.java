package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void testSomeMethod() {
        ImmutableLinkedList list = new ImmutableLinkedList(1);
        ImmutableList newList = list.add(3);
        assertEquals("[1]", list.toString());
        assertEquals("[1, 3]", newList.toString());
    }
    
}
