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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            boolean siblings = false;
            boolean cousins = false;
            int nodeAtDepth = q.size();
            for(int i = 0; i < nodeAtDepth; i++){
                TreeNode node = q.remove();
                if(node == null){
                    siblings = false;
                }
                else{
                    if(node.val == x || node.val == y){
                        if(!cousins){
                            siblings = cousins = true;
                        }
                        else{
                            return !siblings;
                        }
                    }
                    if(node.left != null){
                        q.add(node.left);
                    }
                    if(node.right != null){
                        q.add(node.right);
                    }
                    q.add(null);
                }
            }
            if(cousins){
                return false;
            }
        }
        return false;
    }
}
