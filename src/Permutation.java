import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> q = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);
        int count = 0;
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
            count++;
        }
        if (k <= count) {
            for (int i = 0; i < k; i++)
                StdOut.println(q.dequeue());
        } else System.out.println("Randomized queue underflow error");
    }
}
