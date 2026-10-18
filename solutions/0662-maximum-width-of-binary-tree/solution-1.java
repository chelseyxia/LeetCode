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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<Pair<TreeNode, Integer>> q = new LinkedList<>();
        int max_width = 0;
        q.addLast(new Pair<>(root, 0));
        while(q.size() > 0){
            Pair<TreeNode, Integer> head = q.getFirst();
            int cur_level_size = q.size();
            Pair<TreeNode, Integer> elem = null;
            for(int i = 0; i < cur_level_size; ++i){
                elem = q.removeFirst();
                TreeNode node = elem.getKey();
                if(node.left != null){
                    q.addLast(new Pair<>(node.left, 2 * elem.getValue()));
                }
                if(node.right != null){
                    q.addLast(new Pair<>(node.right, 2 * elem.getValue() + 1));
                }
            }
            max_width = Math.max(max_width, elem.getValue() - head.getValue() + 1);
        }
        return max_width;
    }
}
