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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return buildBST(Integer.MIN_VALUE, preorder, Integer.MAX_VALUE, n);
    }
    
    private TreeNode buildBST(int lower, int[] preorder, int upper, int n){
        if(n == index){
            return null;
        }       
        int val = preorder[index];
        if(val < lower || val > upper){
            return null;
        }
        index++;
        TreeNode root = new TreeNode(val);
        root.left = buildBST(lower, preorder, val, n);
        root.right = buildBST(val, preorder, upper, n);
        return root;
    }
}
