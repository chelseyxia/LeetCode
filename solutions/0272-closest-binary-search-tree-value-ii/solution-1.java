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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> dq = new LinkedList();
        inorder(dq, root, target, k);
        return new ArrayList(dq);
    }
    
    private void inorder(Deque<Integer> dq, TreeNode node, double target, int k){
        if(node == null){
            return;
        }
        //start inorder 
        inorder(dq, node.left, target, k);
        double val = Double.valueOf(node.val);
        if(dq.size() == k){
            if(Math.abs(Double.valueOf(dq.peekFirst()) - target) > Math.abs(val - target)){
                dq.pollFirst();
                dq.addLast(node.val);
            }
            else{
                return;
            }
        }
        else{
            dq.addLast(node.val);
        }
        inorder(dq, node.right, target, k);
    }
}
