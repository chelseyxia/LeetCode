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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return ans;
    }
    public int longestPath(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftPath = 0;
        int rightPath = 0;
        leftPath = longestPath(node.left);
        rightPath = longestPath(node.right);
        ans = Math.max(ans, leftPath + rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }
}
