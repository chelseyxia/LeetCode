class Solution {
    
    private Map<Integer, List<Integer>> graph;
    private Map<Integer, Integer> rank;
    private Map<Pair<Integer, Integer>, Boolean> connDict;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.formGraph(n, connections);
        this.dfs(0, 0);
        
        List<List<Integer>> result = new ArrayList();
        
        for(Pair<Integer, Integer> criticalConnection : this.connDict.keySet()){
            result.add(new ArrayList<Integer>(Arrays.asList(criticalConnection.getKey(), criticalConnection.getValue())));
        }
        
        return result;
    }
    
    private int dfs(int node, int discoveryRank){
        if(this.rank.get(node) != null){
            return this.rank.get(node);
        }
        
        this.rank.put(node, discoveryRank);
        
        int minRank = discoveryRank + 1;
        
        for(Integer nei : this.graph.get(node)){
            Integer neiRank = this.rank.get(nei);
            if(neiRank != null && neiRank == discoveryRank - 1){
                continue;
            }
            
            int recursiveRank = this.dfs(nei, discoveryRank + 1);
            
            if(recursiveRank <= discoveryRank){
                int sortedU = Math.min(node, nei);
                int sortedV = Math.max(node, nei);
                this.connDict.remove(new Pair<Integer, Integer>(sortedU, sortedV));
            }
            
            minRank = Math.min(minRank, recursiveRank);
        }
        
        return minRank;
    }
    
    
    private void formGraph(int n, List<List<Integer>> connections){
        this.graph = new HashMap<Integer, List<Integer>>();
        this.rank = new HashMap();
        this.connDict = new HashMap<Pair<Integer, Integer>, Boolean>();
        
        for(int i = 0; i < n; i++){
            this.graph.put(i, new ArrayList<Integer>());
            this.rank.put(i, null);    
        }
        
        for(List<Integer> edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);
            this.graph.get(u).add(v);
            this.graph.get(v).add(u);
            int sortU = Math.min(u, v);
            int sortV = Math.max(u, v);
            connDict.put(new Pair<Integer, Integer>(sortU, sortV), true);
        }
    }
}
