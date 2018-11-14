import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] q;       // queue elements
    private int n;          // number of elements on queue
    private int rand;

    /**
     * Construct an empty randomized queue.
     */
    public RandomizedQueue() {
        q = (Item[]) new Object[2];
        n = 0;
    }

    /**
     * Checks if the deque is empty.
     * @return true if this randomized queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    // resize the underlying array
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = q[i];
        }
        q = temp;
    }

    /**
     * Return the number of items on the randomized queue.
     * @return the number of items on the randomized queue
     */
    public int size() {
        return n;
    }

    /**
     * Add the item to the randomized queue.
     * @param item the item to add
     * @throws java.lang.IllegalArgumentException if calls with a null argument
     */
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Null argument");
        // double size of array if necessary and recopy to front of array
        if (n == q.length) resize(2*q.length);   // double size of array if necessary
        q[n++] = item;                                  // add item
    }

    /**
     * Remove and return a random item:
     *     - If the array is empty, throw an exception and exit.
     *     - Call Sample function to return a random number between 0 and N-1.
     *     - Now, swap this element at random position with the last one.
     *     - Decrease the last to next element.
     *     - Decrease the number of items in array i.e. N by 1.
     *     - If required, decrease size of array by half.
     *     - Return the removed item.
     * @return random item of the randomized queue
     * @throws java.util.NoSuchElementException if this randomized queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Randomized queue underflow");
        Item item = sample();
        q[rand] = q[n-1];
        q[n-1] = null;                                  // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == q.length/4) resize(q.length/2);
        return item;
    }

    /**
     * Return a random item, but do not remove it:
     *      - If there is more than one element in the array return a random number between 0 and N-1.
     *      - Else return 0.
     * @return a random item of the randomized queue
     * @throws java.util.NoSuchElementException if this randomized queue is empty
     */
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Randomized queue underflow");
        if (n > 1) {
            rand = StdRandom.uniform(n);
            return q[rand];
        }
            else {
                rand = 0;
                return q[0];
            }
    }

    /**
     * Return an independent iterator over items in random order.
     * @return an independent iterator over items in random order
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public ArrayIterator() {
            StdRandom.shuffle(q, 0, n);
        }
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            return q[i++];
        }
    }

    /**
     * Unit tests the {@code RandomizedQueue} data type.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-") && !item.equals("=") &&  !item.equals("i")) q.enqueue(item);
            else if (!q.isEmpty() && item.equals("=")) StdOut.print(q.sample() + " \n");
            else if (!q.isEmpty() && item.equals("i")) {
                for (String i : q) {
                    StdOut.print(i + " ");
                }
                StdOut.println("\n(" + q.size() + " left in RandomizedQueue)");
            }
            else if (!q.isEmpty() && item.equals("-")) StdOut.print(q.dequeue() + " \n");
        }

        StdOut.println("(" + q.size() + " left in RandomizedQueue)");
    }
}



