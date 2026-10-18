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
    private TreeNode ans;
    public Solution(){
        this.ans = null;
    }
    private boolean LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        boolean lson = LCA(root.left, p, q);
        boolean rson = LCA(root.right, p, q);
        if((lson && rson) || (((lson || rson) && (root.val == p.val) || (root.val == q.val)))){
            ans = root;
        }
        return lson || rson || (root.val == p.val) || (root.val == q.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LCA(root, p, q);
        return ans;
    }
}
