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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList();
        if(root == null){
            return ans;
        }
        helper(root, ans, 0);
        return ans;
    }
    private void helper(TreeNode node, List<Integer> ans, int level){
        if(node == null){
            return;
        }
        if(ans.size() == level){
            ans.add(node.val);
        }
        helper(node.right, ans, level + 1);
        helper(node.left, ans, level + 1);
    }
}
