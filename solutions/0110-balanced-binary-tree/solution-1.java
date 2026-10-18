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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftLength = height(root.left);
        int rightLength = height(root.right);
        int n = Math.abs(leftLength - rightLength);
        if(n > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root == null){
            return -1;
        }
        int height = Math.max(height(root.left), height(root.right));
        return height + 1;
    }
}
