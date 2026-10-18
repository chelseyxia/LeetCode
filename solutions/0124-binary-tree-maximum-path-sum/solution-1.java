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
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max_sum;
    }
    public int maxSum(TreeNode node){
        if(node == null){
            return 0;
        }        
        int left_gain = Math.max(maxSum(node.left), 0);
        int right_gain = Math.max(maxSum(node.right), 0);
        int price_newPath = node.val + left_gain + right_gain;
        max_sum = Math.max(max_sum, price_newPath);
        return node.val + Math.max(left_gain, right_gain);
    }
}
