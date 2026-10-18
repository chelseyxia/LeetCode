class Solution {
    ArrayList<Integer>[] graph;
    Map<Integer, Integer> color;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new ArrayList[n + 1];
        color = new HashMap();
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] dislike : dislikes){
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        
        for(int node = 1; node < n + 1; node++){
            if(!color.containsKey(node)){
                boolean ok = dfs(node, 0);
                if(!ok){
                    return false;
                }
                else{
                    continue;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(int node, int c){
        if(color.containsKey(node)){
            boolean ok = color.get(node) == c;
            return ok;
        }
        color.put(node, c);
        for(int noFriend : graph[node]){
            boolean ok = dfs(noFriend, c ^ 1);
            if(!ok){
                return false;
            }
        }
        return true;
    }
}
