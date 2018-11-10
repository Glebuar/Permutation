import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestDeque {

    @Test
    void numberOfElementsNotLessThanZero() {
        Deque<String> queue = new Deque<>();
        assertFalse(queue.size() < 0);
    }

    @Test
    void firstAndLastIsNullWhenZeroElements() {
        Deque<String> queue = new Deque<>();
        assertFalse(queue.first != null || queue.last != null);
    }

    @Test
    void firstOrLastIsNotNullWhenOneElementInList() {
        Deque<String> queue = new Deque<>();
        String item = "One";
        queue.addLast(item);
        assertFalse(queue.first == null || queue.last == null);
    }

    @Test
    void firstNextIsEqualNullWhenOneElementInList() {
        Deque<String> queue = new Deque<>();
        String item = "One";
        queue.addLast(item);
        assertNull(queue.first.next);
    }

    @Test
    void firstIsEqualLastWhenOneElementInList() {
        Deque<String> queue = new Deque<>();
        String item = "One";
        queue.addLast(item);
        assertEquals(queue.first, queue.last);
    }

    @Test
    void firstOrLastIsNotNullWhenSeveralElementsInList() {
        Deque<String> queue = new Deque<>();
        String item = "Several";
        queue.addFirst(item);
        queue.addLast(item);
        assertFalse(queue.first == null || queue.last == null);
    }

    @Test
    void firstIsNotEqualLastWhenSeveralElementsInList() {
        Deque<String> queue = new Deque<>();
        String item = "Several";
        queue.addFirst(item);
        queue.addLast(item);
        assertNotEquals(queue.first, queue.last);
    }

    @Test
    void firstNextIsNotEqualNullWhenSeveralElementsInList() {
        Deque<String> queue = new Deque<>();
        String item = "Several";
        queue.addFirst(item);
        queue.addLast(item);
        assertNotNull(queue.first.next);
    }

    @Test
    void lastNextIsEqualNullWhenSeveralElementsInList() {
        Deque<String> queue = new Deque<>();
        String item = "Several";
        queue.addFirst(item);
        queue.addLast(item);
        assertNull(queue.last.next);
    }

    @Test
    void internalConsistencyOfInstanceVarLastWhenSeveralElementsInList() {
        Deque<String> queue = new Deque<>();
        String item = "Several";
        queue.addFirst(item);
        queue.addLast(item);
        queue.addLast(item);
        Deque<?>.Node lastNode = queue.first;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        assertEquals(queue.last, lastNode);
    }

    @Test
    void internalConsistencyOfInstanceVarNWhenSeveralElementsInList() {
        Deque<String> queue = new Deque<>();
        String item = "Several";
        queue.addFirst(item);
        queue.addFirst(item);
        queue.addLast(item);
        int numberOfNodes = 0;
        for (Deque<?>.Node x = queue.first; x != null && numberOfNodes <= queue.n; x = x.next) {
            numberOfNodes++;
        }
        assertEquals(numberOfNodes, queue.n);
    }
}