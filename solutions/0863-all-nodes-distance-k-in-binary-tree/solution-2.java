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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Set<TreeNode> visited = new HashSet<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        DFS(map, root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(k == 0){
                // add all this layer's values
                for(int i = 0; i < size; i++){
                    TreeNode curNode = queue.poll();
                    list.add(curNode.val);
                }
                return list;
            }
            for(int i = 0; i < size; i++){
                TreeNode curNode = queue.poll();
                if(curNode.left != null && !visited.contains(curNode.left)){
                    visited.add(curNode.left);
                    queue.offer(curNode.left);
                }
                if(curNode.right != null && !visited.contains(curNode.right)){
                    visited.add(curNode.right);
                    queue.offer(curNode.right);
                }
                TreeNode parentNode = map.get(curNode);
                if(parentNode != null && !visited.contains(parentNode)){
                    visited.add(parentNode);
                    queue.offer(parentNode);
                }
            }
            k--;
        }
        return new ArrayList<>();
    }
    public void DFS(Map<TreeNode, TreeNode> map, TreeNode node){
        if(node == null){
            return;
        }
        if(node.left != null){
            map.put(node.left, node);
            DFS(map, node.left);
        }
        if(node.right != null){
            map.put(node.right, node);
            DFS(map, node.right);
        }
    }
}
