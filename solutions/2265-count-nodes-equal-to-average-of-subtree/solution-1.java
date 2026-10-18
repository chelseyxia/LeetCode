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
    public int averageOfSubtree(TreeNode root) {
        int[] ans = postOrder(root);
        return ans[2];
    }
    public int[] postOrder(TreeNode node){
        if(node == null){
            return new int[]{0, 0, 0};
        }
        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);
        int sum = left[0] + right[0] + node.val;
        int nodeCount = left[1] + right[1] + 1;
        int count = left[2] + right[2];
        if(sum / nodeCount == node.val){
            count++;
        }
        return new int[]{sum, nodeCount, count};
    }

}
