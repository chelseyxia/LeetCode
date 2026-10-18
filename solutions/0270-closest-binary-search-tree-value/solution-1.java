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
    public int closestValue(TreeNode root, double target) {
        int closestValue = root.val;
        TreeNode node = root;
        while(node != null){
            int currVal = node.val;
            if(Math.abs(currVal - target) < Math.abs(closestValue - target)){
                closestValue = currVal;
            }
            
            if(currVal > target){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
        
        return closestValue;
    }
}
