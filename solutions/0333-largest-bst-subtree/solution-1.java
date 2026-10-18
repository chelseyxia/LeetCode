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
    private TreeNode previous;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }
        previous = null;
        if(isValidTree(root)){
            return countNodes(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    public boolean isValidTree(TreeNode root){
        if(root == null){
            return true;
        }
        if(!isValidTree(root.left)){
            return false;
        }
        if(previous != null && previous.val >= root.val){
            return false;
        }
        previous = root;
        return isValidTree(root.right);
    }
    public int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
