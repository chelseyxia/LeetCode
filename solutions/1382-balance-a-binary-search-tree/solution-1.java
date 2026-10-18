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
    LinkedList<Integer> list;    
    public TreeNode balanceBST(TreeNode root) {
        list = new LinkedList<Integer>();
        inOrder(root);
        int size = list.size();
        return helper(0, size - 1);
        
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public TreeNode helper(int l, int r){
        if(l > r){
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = helper(l, mid - 1);
        node.right = helper(mid + 1, r);
        return node;
    }
}
