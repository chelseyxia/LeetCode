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
    HashMap<TreeNode, int[]> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap();
        map.put(root, new int[]{0, 0, root.val});//col, row, root.val
        DFS(root);  
        
        List<int[]> list = new ArrayList<>(map.values());
        Collections.sort(list, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        int n = list.size();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; ){
            int j = i;
            List<Integer> temp = new ArrayList();
            while(j < n && list.get(j)[0] == list.get(i)[0]){
                temp.add(list.get(j++)[2]);
            }
            ans.add(temp);
            i = j;
        }
        return ans;
    }
    public void DFS(TreeNode node){
        if(node == null){
            return;
        }
        int[] info = map.get(node);
        int col = info[0], row = info[1];
        if(node.left != null){
            map.put(node.left, new int[]{col - 1, row + 1, node.left.val});
            DFS(node.left);
        }
        if(node.right != null){
            map.put(node.right, new int[]{col + 1, row + 1, node.right.val});
            DFS(node.right);
        }
       
    }
}
