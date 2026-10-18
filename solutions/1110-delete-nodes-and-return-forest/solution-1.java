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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new LinkedList();
        Set<Integer> set = new HashSet();
        for(int num : to_delete){
            set.add(num);
        }
        list.add(root);
        TreeNode node = del(root, set, list);
        return list;
    }
    
    private TreeNode del(TreeNode node, Set<Integer> delete, List<TreeNode> list){
        if(node == null){
            return null;
        }
        node.left = del(node.left, delete, list);
        node.right = del(node.right, delete, list);
        if(delete.contains(node.val)){
            if(node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
            if(list.contains(node)){
                list.remove(node);
            }
            return null;
        }
        return node;
    }
}
