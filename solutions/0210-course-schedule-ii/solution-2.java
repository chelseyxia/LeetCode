class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        //dfs
        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topoOrder = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int[] pre : prerequisites){
            int dest = pre[0];
            int src = pre[1];
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(dest);
            indegree[dest]++;
        }
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int i = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            topoOrder[i++] = node;
            if(adjList.containsKey(node)){
                for(int neighbor : adjList.get(node)){
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 0){
                        queue.add(neighbor);
                    }
                }
            }
        }
        
        if(i == numCourses){
            return topoOrder;
        }
        return new int[0];
        
    }
}
