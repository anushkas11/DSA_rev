import java.util.*;

class Solution {
    static class Node {
        int freq;
        char ch;
        Node left, right;
        Node(int f, char c) { freq = f; ch = c; }
        Node(int f, Node l, Node r) { freq = f; left = l; right = r; }
    }

    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (int i = 0; i < N; i++) pq.add(new Node(f[i], S.charAt(i)));
        while (pq.size() > 1) {
            Node a = pq.poll(), b = pq.poll();
            pq.add(new Node(a.freq + b.freq, a, b));
        }
        ArrayList<String> res = new ArrayList<>();
        build(pq.peek(), "", res);
        return res;
    }

    void build(Node root, String s, ArrayList<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(s);
            return;
        }
        build(root.left, s + "0", res);
        build(root.right, s + "1", res);
    }
}
