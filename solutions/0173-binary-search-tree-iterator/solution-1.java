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
class BSTIterator {
    ArrayList<Integer> nodesSorted;
    int index;
    public BSTIterator(TreeNode root) {
        this.nodesSorted = new ArrayList<Integer>();
        this.index = -1;
        this.inOrder(root);
    }
    
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        this.inOrder(root.left);
        this.nodesSorted.add(root.val);
        this.inOrder(root.right);
    }
    
    public int next() {
        return nodesSorted.get(++index);
    }
    
    public boolean hasNext() {
        return index + 1 < nodesSorted.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
