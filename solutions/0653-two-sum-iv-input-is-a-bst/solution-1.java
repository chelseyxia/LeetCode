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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            if(queue.peek() != null){
                TreeNode q = queue.remove();
                if(set.contains(k - q.val)){
                    return true;
                }
                set.add(q.val);
                queue.add(q.right);
                queue.add(q.left);
            }
            else{
                queue.remove();
            }
        }
        return false;
    }
}
