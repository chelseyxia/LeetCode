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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ave_list = new LinkedList<Double>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            double sum = 0;
            double cnt = 0;
            Stack<TreeNode> temp = new Stack<TreeNode>();
            while(!stack.isEmpty()){
                TreeNode s = stack.pop();
                cnt++;
                sum += s.val;
                if(s.left != null){
                    temp.push(s.left);
                }
                if(s.right != null){
                    temp.push(s.right);
                }
            }
            stack = temp;
            ave_list.add(sum / cnt);            
        }
        return ave_list;
    }
}
