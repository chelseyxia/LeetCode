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
    public List<Integer> getLonelyNodes(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int shouldAdd = 0;
            if(node.left != null){
                shouldAdd++;
                stack.push(node.left);
            }
            if(node.right != null){
                shouldAdd++;
                stack.push(node.right);                
            }  
            if(shouldAdd == 1){
                list.add(node.left == null ? node.right.val : node.left.val);
            }
        }
        return list;
    }
}
