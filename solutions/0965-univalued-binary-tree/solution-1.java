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
    List<Integer> list;
    public boolean isUnivalTree(TreeNode root) {
        list = new ArrayList();
        dfs(root);
        for(int v : list){
            if(v != root.val){
                return false;
            }
        }
        return true;
    }
    public void dfs(TreeNode root){
        if(root != null){
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }    
    }
}
