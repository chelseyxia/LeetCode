class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if(graph.length == 0 || graph == null){
            return paths;
        }
        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;
    }
    public void dfs(int[][] graph, int node, ArrayList<Integer> path, List<List<Integer>> paths){
        path.add(node);
        if(node == graph.length - 1){
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextnodes = graph[node];
        for(int nextnode : nextnodes){
            dfs(graph, nextnode, path, paths);
            path.remove(path.size() - 1);
        }
        
    }
}
