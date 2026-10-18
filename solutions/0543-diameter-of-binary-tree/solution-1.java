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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        //int ans = 0;
        dfs(root);
        return ans - 1;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = 0;
        int r = 0;
        if(root.left != null){
            l += dfs(root.left);
        } 
        if(root.right != null){
            r += dfs(root.right);
        }
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
