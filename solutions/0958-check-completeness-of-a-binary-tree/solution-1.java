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
    int n = 0;
    int p = 0;
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!dfs(root, 1)){
            return false;
        }
        return n == p;
    }
    private boolean dfs(TreeNode node, int k){
        if(node == null){
            return true;
        }
        if(k > 100){
            return false;
        }
        n++;
        p = Math.max(p, k);
        return dfs(node.left, 2 * k) && dfs(node.right, 2 * k + 1);
    }
}
