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
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> ans = new LinkedList<String>();
        construct(root, "", ans);
        return ans;
    }
    public void construct(TreeNode root, String path, LinkedList<String> paths){
        if(root != null){
            path += Integer.toString(root.val);
            if(root.left == null && root.right == null){
                paths.add(path);
            }
            else{
                path += "->";
            }
            construct(root.left, path, paths);
            construct(root.right, path, paths);
        } 
    }
}
