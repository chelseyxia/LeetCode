/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean pFound, qFound;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = helper(root, p, q);
        if(pFound && qFound){
            return result;
        }
        return null;
    }
   
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        TreeNode tleft = helper(root.left, p, q);
        TreeNode tright = helper(root.right, p, q);
        
        if(root == p || root == q){
            if(root == p){
                pFound = true;
            }
            if(root == q){
                qFound = true;
            }
            return root;
        }
        if(tleft != null && tright != null){
            return root;
        }
        return tleft != null ? tleft : tright;
    }
}
