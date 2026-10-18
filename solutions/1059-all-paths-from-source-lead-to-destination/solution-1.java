class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, Set<Integer>> map = new HashMap();
        for(int[] edge : edges){
            int start = edge[0];
            int end = edge[1];
            if(!map.containsKey(start)){
                map.put(start, new HashSet<Integer>());
            }
            map.get(start).add(end);
        }
        if(map.containsKey(destination)){
            return false;
        }
        return dfs(source, destination, map, new HashSet<>());
    }
    public boolean dfs(int s, int d, HashMap<Integer, Set<Integer>> map, HashSet<Integer> set){
        if(s == d){
            return true;
        }
        set.add(s);
        if(map.get(s) == null){
            return false;
        }
        for(Integer node : map.get(s)){
            if(set.contains(node)){
                return false;
            }
            if(!dfs(node, d, map, set)){
                return false;
            }
        }
        set.remove(s);
        return true;
    }
}
