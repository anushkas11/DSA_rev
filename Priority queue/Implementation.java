import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Iterator;

class Geeks {

    static void insert(PriorityQueue<Integer> q, int k) {
        q.add(k);
    }

    static boolean find(PriorityQueue<Integer> q, int k) {
        return q.contains(k);
    }

    static int delete(PriorityQueue<Integer> q) {
        return q.poll(); // removes and returns the max element
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        insert(q, 10);
        insert(q, 20);
        insert(q, 5);

        System.out.println(find(q, 20)); // true
        System.out.println(find(q, 15)); // false

        System.out.println(delete(q)); // 20
        System.out.println(delete(q)); // 10
    }
}
