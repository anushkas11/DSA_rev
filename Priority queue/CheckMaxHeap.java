class Solution {
    public boolean isHeap(Node tree) {
        int count = countNodes(tree);
        return isComplete(tree, 0, count) && isHeapUtil(tree);
    }

    private int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private boolean isComplete(Node root, int index, int count) {
        if (root == null) return true;
        if (index >= count) return false;
        return isComplete(root.left, 2 * index + 1, count) && isComplete(root.right, 2 * index + 2, count);
    }

    private boolean isHeapUtil(Node root) {
        if (root.left == null && root.right == null) return true;
        if (root.right == null) return root.data >= root.left.data;
        if (root.data >= root.left.data && root.data >= root.right.data)
            return isHeapUtil(root.left) && isHeapUtil(root.right);
        return false;
    }
}
