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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        inOrder(root, list, k);
        return list.get(k - 1);
    }
    private void inOrder(TreeNode root, List<Integer> list, int k){
        if(root == null || list.size() == k){
            return;
        }
        inOrder(root.left, list, k);
        if(list.size() < k){
            list.add(root.val);   
        }
        inOrder(root.right, list, k);
    }
}
