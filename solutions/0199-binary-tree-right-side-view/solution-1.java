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
        if(root == null){
            return new LinkedList<Integer>();
        }
        List<Integer> rightSide = new LinkedList<Integer>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> curLevel = new ArrayDeque<TreeNode>();
        nextLevel.offer(root);
        TreeNode node = null;
        while(!nextLevel.isEmpty()){
            curLevel = nextLevel.clone();
            nextLevel.clear();
            while(!curLevel.isEmpty()){
                node = curLevel.poll();
                if(node.left != null){
                    nextLevel.offer(node.left);
                }
                if(node.right != null){
                    nextLevel.offer(node.right);
                }
            }
            if(curLevel.isEmpty()){
                rightSide.add(node.val);
            }
        }
        return rightSide;
    }
}
