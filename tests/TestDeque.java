/*

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestDeque {

    @Test
    void numberOfElementsNotLessThanZero() {
        Deque<String> deque = new Deque<>();
        assertFalse(deque.size() < 0);
    }

    @Test
    void firstAndLastIsNullWhenZeroElements() {
        Deque<String> deque = new Deque<>();
        assertFalse(deque.first != null || deque.last != null);
    }

    @Test
    void firstOrLastIsNotNullWhenOneElementInList() {
        Deque<String> deque = new Deque<>();
        String item = "One";
        deque.addLast(item);
        assertFalse(deque.first == null || deque.last == null);
    }

    @Test
    void firstNextIsEqualNullWhenOneElementInList() {
        Deque<String> deque = new Deque<>();
        String item = "One";
        deque.addLast(item);
        assertNull(deque.first.next);
    }

    @Test
    void firstIsEqualLastWhenOneElementInList() {
        Deque<String> deque = new Deque<>();
        String item = "One";
        deque.addLast(item);
        assertEquals(deque.first, deque.last);
    }

    @Test
    void firstOrLastIsNotNullWhenSeveralElementsInList() {
        Deque<String> deque = new Deque<>();
        String item = "Several";
        deque.addFirst(item);
        deque.addLast(item);
        assertFalse(deque.first == null || deque.last == null);
    }

    @Test
    void firstIsNotEqualLastWhenSeveralElementsInList() {
        Deque<String> deque = new Deque<>();
        String item = "Several";
        deque.addFirst(item);
        deque.addLast(item);
        assertNotEquals(deque.first, deque.last);
    }

    @Test
    void firstNextIsNotEqualNullWhenSeveralElementsInList() {
        Deque<String> deque = new Deque<>();
        String item = "Several";
        deque.addFirst(item);
        deque.addLast(item);
        assertNotNull(deque.first.next);
    }

    @Test
    void lastNextIsEqualNullWhenSeveralElementsInList() {
        Deque<String> deque = new Deque<>();
        String item = "Several";
        deque.addFirst(item);
        deque.addLast(item);
        assertNull(deque.last.next);
    }

    @Test
    void internalConsistencyOfInstanceVarLastWhenSeveralElementsInList() {
        Deque<String> deque = new Deque<>();
        String item = "Several";
        deque.addFirst(item);
        deque.addLast(item);
        deque.addLast(item);
        Deque<?>.Node lastNode = deque.first;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        assertEquals(deque.last, lastNode);
    }

    @Test
    void internalConsistencyOfInstanceVarNWhenSeveralElementsInList() {
        Deque<String> deque = new Deque<>();
        String item = "Several";
        deque.addFirst(item);
        deque.addFirst(item);
        deque.addLast(item);
        int numberOfNodes = 0;
        for (Deque<?>.Node x = deque.first; x != null && numberOfNodes <= deque.n; x = x.next) {
            numberOfNodes++;
        }
        assertEquals(numberOfNodes, deque.n);
    }
}*/
