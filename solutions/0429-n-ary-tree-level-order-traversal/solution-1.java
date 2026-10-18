/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        //group use null to split
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        if(root == null){
            return ans;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int j = 0; j < size; j++){
                Node temp = queue.poll();
                level.add(temp.val);
                queue.addAll(temp.children);
            }
            ans.add(level);
        }
        return ans;
    }
}
