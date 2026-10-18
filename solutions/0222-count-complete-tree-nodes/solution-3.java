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
    int ans = 1;
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        //int ans = 0;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        if(node.left != null){
            dfs(node.left);
            ans++;
        }
        if(node.right != null){
            dfs(node.right);
            ans++;
        }
    }
}
