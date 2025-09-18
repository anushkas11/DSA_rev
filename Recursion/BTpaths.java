import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class BTpaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        helper(root, ans, "");
        return ans;
    }

    private static void helper(TreeNode root, List<String> ans, String path) {
        if (root == null) return;

        if (path.isEmpty()) {
            path = "" + root.val;
        } else {
            path = path + "->" + root.val;
        }
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        if (root.left != null) {
            helper(root.left, ans, path);
        }
        if (root.right != null) {
            helper(root.right, ans, path);
        }
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        List<String> paths = binaryTreePaths(root);
        for (String p : paths) {
            System.out.println(p);
        }
    }
}
