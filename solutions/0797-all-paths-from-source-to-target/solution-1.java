class Solution {    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList();
        
        
        //call dfs
        dfs(graph, 0, new ArrayList(), paths);
        //0 1 3        0 2 3
        return paths;
    }
    //dfs
    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths){
        path.add(node);
        if(node == graph.length - 1){
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextNodes = graph[node];
        for(int nextNode : nextNodes){
            dfs(graph, nextNode, path, paths);
            path.remove(path.size() - 1);
        }
    }
}
