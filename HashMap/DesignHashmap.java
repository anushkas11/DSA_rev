import java.util.*;

class MyHashMap {
    private static class Pair {
        int key, value;
        Pair(int k, int v) { key = k; value = v; }
    }

    private final int SIZE = 1000;
    private List<Pair>[] buckets;

    public MyHashMap() {
        buckets = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++) buckets[i] = new ArrayList<>();
    }

    public void put(int key, int value) {
        int hash = key % SIZE;
        for (Pair p : buckets[hash]) {
            if (p.key == key) {
                p.value = value;
                return;
            }
        }
        buckets[hash].add(new Pair(key, value));
    }

    public int get(int key) {
        int hash = key % SIZE;
        for (Pair p : buckets[hash]) {
            if (p.key == key) return p.value;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = key % SIZE;
        buckets[hash].removeIf(p -> p.key == key);
    }
}
