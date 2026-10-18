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
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap();
        int mode = -1;
        List<Integer> ans = new ArrayList();
        inOrder(root, map);
        for(int key : map.keySet()){
            mode = Math.max(mode, map.get(key));
        }        
        for(int key : map.keySet()){
            if(map.get(key) == mode){
                ans.add(key);
            }
        }
        int[] arr = new int[ans.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
    private void inOrder(TreeNode root, Map<Integer, Integer> map){
        if(root == null){
            return;
        }
        inOrder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inOrder(root.right, map);
    }
}
