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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        return isSub(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSub(TreeNode node, TreeNode subNode){
        if(node == null && subNode == null){
            return true;
        }
        if(node == null || subNode == null || node.val != subNode.val){
            return false;
        }
        return isSub(node.left, subNode.left) && isSub(node.right, subNode.right);
    }
}
