/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post=new ArrayList<>();
        helper(root,post);
        return post;
        
    }
    public void helper(TreeNode root, List<Integer> post){
        if(root==null) return;
        helper(root.left, post);
        helper(root.right,post);
        post.add(root.val);
    }
}