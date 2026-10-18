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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        TreeNode s;
        while(!stack.isEmpty()){
            s = stack.pop();
            if(s.left != null){
                if(s.left.left == null && s.left.right == null){
                    sum += s.left.val; 
                }
                else{
                stack.push(s.left);
                }
            }
            if(s.right != null){
                stack.push(s.right); 
            }
        }
        return sum;
    }
}
