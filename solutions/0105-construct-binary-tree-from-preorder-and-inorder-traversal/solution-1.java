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
    int rootIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int np = preorder.length;
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildtree(map, 0, preorder.length - 1, preorder);
    }
    
    private TreeNode buildtree(Map<Integer, Integer> map, int left, int right, int[] preorder){
        if(left <= right){
            int rootVal = preorder[rootIndex];
            TreeNode root = new TreeNode(rootVal);
            rootIndex++;
            root.left = buildtree(map, left, map.get(rootVal) - 1, preorder);
            root.right = buildtree(map, map.get(rootVal) + 1, right, preorder);
            return root;
        }
        else{
            return null;
        }
    }
}
