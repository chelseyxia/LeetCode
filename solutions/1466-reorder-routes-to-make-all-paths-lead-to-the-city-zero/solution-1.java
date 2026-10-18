class Solution {
    int res = 0;
    public int minReorder(int n, int[][] connections) {
        // 访问所有未访问 neighbor；
        // res += edge cost；
        // 然后继续 DFS。
        boolean[] visited = new boolean[n];
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < connections.length; i++){
            int a = connections[i][0];
            int b = connections[i][1];
            graph.get(a).add(new int[]{b, 1});
            graph.get(b).add(new int[]{a, 0});
        }
        dfs(n, connections, visited, 0, graph);
        return res;
    }
    public void dfs(int n, int[][] connections, boolean[] visited, int start, List<List<int[]>> graph){
        //when to end this dfs?
        visited[start] = true;
        for(int[] edge : graph.get(start)){
            int next = edge[0];
            if (visited[next]){
                continue;
            }
            int needReverse = edge[1];
            if(needReverse == 1){
                res++;
                dfs(n, connections, visited, edge[0], graph);
            }
            else{
                dfs(n, connections, visited, edge[0], graph);
            }
        }
    }
}
