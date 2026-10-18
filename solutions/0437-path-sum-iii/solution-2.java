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
    int k;
    int count = 0;
    HashMap<Integer, Integer> map = new HashMap();

    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preOrder(root, 0);
        return count;
    }
    
    public void preOrder(TreeNode node, int currSum){
        if(node == null){
            return;
        }
        currSum += node.val;
        if(currSum == k){
            count++;
        }
        count += map.getOrDefault(currSum - k, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        preOrder(node.left, currSum);
        preOrder(node.right, currSum);
        map.put(currSum, map.get(currSum) - 1);
    }
}
