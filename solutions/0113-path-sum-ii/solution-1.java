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
    List<List<Integer>> ans = new LinkedList<>();
    Deque<Integer> res = new LinkedList<Integer>();  
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //List<List<Integer>> ans = new ArrayList<>();
        pathsum(root, targetSum);       
        return ans;
    }
    public void pathsum(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        res.offerLast(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            ans.add(new LinkedList(res));
        }
        pathsum(root.left, targetSum);
        pathsum(root.right, targetSum);
        res.pollLast();
    }
}
