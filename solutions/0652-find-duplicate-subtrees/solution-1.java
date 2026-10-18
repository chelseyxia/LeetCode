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
    Map<String, Integer> count;
    List<TreeNode> result;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        result = new ArrayList();
        collect(root);
        return result;
    }
    
    private String collect(TreeNode node){
        if(node == null){
            return "#";
        }
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if(count.get(serial) == 2){
            result.add(node);
        }
        return serial;
    }
}
