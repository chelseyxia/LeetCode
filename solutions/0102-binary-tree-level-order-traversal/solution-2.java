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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null){
            return ans;
        }
        helper(root, 0, ans);
        return ans;
    }
    private void helper(TreeNode node, int level, List<List<Integer>> ans){
        if(ans.size() == level){
            ans.add(new ArrayList());
        }
        ans.get(level).add(node.val);
        if(node.left != null){
            helper(node.left, level + 1, ans);
        }
        if(node.right != null){
            helper(node.right, level + 1, ans);
        }
    }
}
