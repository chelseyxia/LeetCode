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
    List<Integer> rightside = new LinkedList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        path(root, 0);
        return rightside;
    }
    public void path(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(rightside.size() == level){
            rightside.add(root.val);
        }
        path(root.right, level + 1);
        path(root.left, level + 1);
    }
}
