class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacentList = new ArrayList();
        for(int i = 0; i < n; i++){
            adjacentList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjacentList.get(edge[0]).add(edge[1]);
            adjacentList.get(edge[1]).add(edge[0]);
        }
        Map<Integer, Integer> parent = new HashMap();
        
        parent.put(0, -1);
        Stack<Integer> stack = new Stack();
        stack.push(0);
        while(!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbour : adjacentList.get(node)){
                if(parent.get(node) == neighbour){
                    continue;
                }
                if(parent.containsKey(neighbour)){
                    return false;
                }
                stack.push(neighbour);
                parent.put(neighbour, node);
            }
        }
        return parent.size() == n;
    }
}
