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
    private List<List<Integer>> ans;
    public List<List<Integer>> findLeaves(TreeNode root) {
        ans = new ArrayList<>();
        getHeight(root);
        return ans;
        
    }
    public int getHeight(TreeNode root){
        if(root == null){
            return -1;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        if(this.ans.size() == currHeight){
            this.ans.add(new ArrayList<>());
        }
        this.ans.get(currHeight).add(root.val);
        return currHeight;
    }
}
