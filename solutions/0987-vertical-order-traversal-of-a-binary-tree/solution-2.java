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
    class State{
        TreeNode node;
        int row;
        int col;
        State(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(root, 0, 0));
        Map<Integer, List<State>> map = new TreeMap<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                State cur = queue.poll();
                TreeNode node = cur.node;
                int r = cur.row;
                int c = cur.col;
                map.computeIfAbsent(c, k -> new ArrayList<>()).add(cur);
                if(node.left != null){
                    queue.offer(new State(node.left, r+1, c-1));
                }
                if(node.right != null){
                    queue.offer(new State(node.right, r+1, c+1));
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<State>> entry : map.entrySet()){
            List<State> list = entry.getValue();
            list.sort((a,b) -> {
                if(a.row != b.row){
                    return Integer.compare(a.row, b.row);
                }
                return Integer.compare(a.node.val, b.node.val);
            });
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                tmp.add(list.get(i).node.val);
            }
            res.add(tmp);
        }
        return res;
    }
}
