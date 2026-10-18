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
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowBSTAN(root, p, q);
        return ans;
    }
    public TreeNode lowBSTAN(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return ans;
        }
        int n = (node.val - p.val) * (node.val - q.val);
        if(n <= 0){
            ans = node;
            return ans;
        }
        if(p.val < node.val && q.val < node.val){
            lowBSTAN(node.left, p, q);
        }
        if(p.val > node.val && q.val > node.val){
            lowBSTAN(node.right, p, q);
        }
           return ans;
    }
}
