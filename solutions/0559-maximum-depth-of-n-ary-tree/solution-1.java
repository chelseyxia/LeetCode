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
    public int maxDepth(Node root) {
        Queue<Pair<Node, Integer>> stack = new LinkedList<>();
        if(root != null){
            stack.add(new Pair(root, 1));
        }
        int depth = 0;
        while(!stack.isEmpty()){
            Pair<Node, Integer> curr = stack.poll();
            root = curr.getKey();
            int cur_depth = curr.getValue();
            if(root != null){
                depth = Math.max(depth, cur_depth);
                for(Node c : root.children){
                    stack.add(new Pair(c, cur_depth + 1));
                }
            }
        }
        return depth;
    }
}
