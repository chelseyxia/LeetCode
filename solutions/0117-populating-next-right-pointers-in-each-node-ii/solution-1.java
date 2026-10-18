/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node cur = root;
        Node nextLevelStart = null;
        Node tail = null;
        while(cur != null){
            if(nextLevelStart == null && cur.left != null){
                nextLevelStart = cur.left;
                tail = cur.left;
            }
            else if(nextLevelStart != null && cur.left != null){
                tail.next = cur.left;
                tail = cur.left;
            }
            if(nextLevelStart == null && cur.right != null){
                nextLevelStart = cur.right;
                tail = cur.right;
            }
            else if(nextLevelStart != null && cur.right != null){
                tail.next = cur.right;
                tail = cur.right;
            }
            cur = cur.next;
            if(cur == null){
                if(nextLevelStart != null){
                    cur = nextLevelStart;
                    nextLevelStart = null;
                    tail = null;
                }
                else{
                    break;
                }
            }
        }
        return root;
    }
}
