class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> neighbor = new ArrayList<>();
        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);
        for(int i = 0; i < n; i++){
            neighbor.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            neighbor.get(edge[0]).add(edge[1]);
            neighbor.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        seen[source] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node == destination){
                return true;
            }
            for(int nei : neighbor.get(node)){
                if(!seen[nei]){
                    seen[nei] = true;
                    queue.add(nei);
                }
            }
        }
        return false;
    }
}
