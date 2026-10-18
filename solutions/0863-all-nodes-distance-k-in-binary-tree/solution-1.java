/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parent;//child, parent
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap();
        dfs(root, null);//初始化
        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);
        
        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);
        
        int dist = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                if(dist == k){
                    List<Integer> ans = new ArrayList();
                    for(TreeNode n : queue){
                        ans.add(n.val);
                    }
                    return ans;
                }
                queue.offer(null);
                dist++;
            }
            else{
                if(!seen.contains(node.left)){
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if(!seen.contains(node.right)){
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if(!seen.contains(par)){
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }
        return new ArrayList<Integer>();
    }
    public void dfs(TreeNode root, TreeNode par){
        if(root != null){
            parent.put(root, par);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}

//find it,
