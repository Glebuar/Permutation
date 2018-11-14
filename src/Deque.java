import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int n;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {

        private Item item;
        private Node next, prev;
    }

    /**
     * Construct an empty deque.
     */
    public Deque() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Checks if the deque is empty.
     * @return true if this deque is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Return the number of items on the deque.
     * @return the number of items in this deque
     */
    public int size() {
        return n;
    }

    /**
     * Add the item to the front of deque.
     * @param item the item to add
     * @throws java.lang.IllegalArgumentException if calls with a null argument
     */
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("Null argument");
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (isEmpty()) last = first;
        else           oldfirst.prev = first;
        n++;
    }

    /**
     * Add the item to the end of deque.
     * @param item the item to add
     * @throws java.lang.IllegalArgumentException if calls with a null argument
     */
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("Null argument");
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldlast;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    /**
     * Remove and return the item from the front of deque.
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this deque is empty
     */
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = first.item;       // save item to return
        first = first.next;           // delete first node
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Remove and return the item from the end of deque.
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this deque is empty
     */
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = last.item;        // save item to return
        last = last.prev;             // delete last node
        last.next = null;             // delete next link
        n--;
        if (isEmpty()) first = null;  // to avoid loitering
        return item;
    }

    /**
     * Return an iterator over items in order from front to end.
     * @return an iterator that iterates over the items in this deque
     */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext()  {
            return current != null;
        }

        public void remove()      {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Unit tests the {@code Deque} data type.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        Deque<String> deque = new Deque<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("1"))
                deque.addFirst(item);
            else if (item.equals("2"))
                deque.addLast(item);
            else if (!deque.isEmpty() && item.equals("3"))
                deque.removeFirst();
            else if (!deque.isEmpty() && item.equals("4"))
                deque.removeLast();
        }
        for (String s : deque) {
            StdOut.println(s);
        }
        StdOut.println("(" + deque.size() + " left on Deque)");
    }
}