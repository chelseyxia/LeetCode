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
    Queue<Integer> q;
    public TreeNode increasingBST(TreeNode root) {
        q = new LinkedList();
        TreeNode newRoot = new TreeNode(0);
        TreeNode cur = newRoot;
        inOrder(root);
        while(!q.isEmpty()){
            cur.right = new TreeNode(q.poll());
            cur = cur.right;
        }
        return newRoot.right;  
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        q.add(root.val);
        inOrder(root.right);
    }
}
