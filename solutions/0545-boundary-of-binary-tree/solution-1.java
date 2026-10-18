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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> left_b = new LinkedList();
        List<Integer> right_b = new LinkedList();
        List<Integer> leaves = new LinkedList();
        preOrder(root, left_b, right_b, leaves, 0);
        left_b.addAll(leaves);
        left_b.addAll(right_b);
        return left_b;
    }
    
    public boolean isLeftB(int flag){
        return flag == 1;
    }
    
    public boolean isRightB(int flag){
        return flag == 2;
    }
    
    public boolean isRoot(int flag){
        return flag == 0;
    }
    
    public boolean isLeaf(TreeNode curr){
        return curr.left == null && curr.right == null;
    }
    
    public int leftChildFlag(TreeNode curr, int flag){
        if(isLeftB(flag) || isRoot(flag)){
            return 1;
        }
        else if(isRightB(flag) && curr.right == null){
            return 2;
        }
        return 3;
    }
    
    public int rightChildFlag(TreeNode curr, int flag){
        if(isRightB(flag) || isRoot(flag)){
            return 2;
        }
        else if(isLeftB(flag) && curr.left == null){
            return 1;
        }
        return 3;
    }
    
    public void preOrder(TreeNode curr, List<Integer> left_b, List<Integer> right_b, List<Integer> leaves, int flag){
        if(curr == null){
            return;
        }
        if(isRightB(flag)){
            right_b.add(0, curr.val);
        }
        else if(isLeftB(flag) || isRoot(flag)){
            left_b.add(curr.val);
        }
        else if(isLeaf(curr)){
            leaves.add(curr.val);
        }
        preOrder(curr.left, left_b, right_b, leaves, leftChildFlag(curr, flag));
        preOrder(curr.right, left_b, right_b, leaves, rightChildFlag(curr, flag));
    }
}
