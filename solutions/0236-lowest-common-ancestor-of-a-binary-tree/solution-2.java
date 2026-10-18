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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode tleft = null, tright = null;
        if(root.left != null){
            tleft = lowestCommonAncestor(root.left, p, q);
        }
        if(root.right != null){
            tright = lowestCommonAncestor(root.right, p, q);
        }
        if(tleft != null && tright != null){
            return root;
        }
        return tleft != null ? tleft : tright;
    }
}
