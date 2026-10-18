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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if(root == null){
            return null;
        }
        for(TreeNode node : nodes){
            if(root == node){
                return root;
            }
        }
        TreeNode tLeft = null, tRight = null;
        tLeft = lowestCommonAncestor(root.left, nodes);
        tRight = lowestCommonAncestor(root.right, nodes);
        if(tLeft != null && tRight != null){
            return root;
        }
        return tLeft == null ? tRight : tLeft;
    }
}
