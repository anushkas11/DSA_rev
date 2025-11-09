class Trie {
    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null)
                cur.children[idx] = new Node();
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null)
                return false;
            cur = cur.children[idx];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null)
                return false;
            cur = cur.children[idx];
        }
        return true;
    }
}
