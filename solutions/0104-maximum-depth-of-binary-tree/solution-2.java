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
    public int maxDepth(TreeNode root) {
        int res = 0;
        res = dfs(root);
        return res;
    }
    public int dfs(TreeNode node){
        int ans = 0;
        if(node == null){
            return 0;
        }
        int maxLeft = dfs(node.left);
        int maxRight = dfs(node.right);
        return Math.max(maxLeft, maxRight) + 1;
    }
}
