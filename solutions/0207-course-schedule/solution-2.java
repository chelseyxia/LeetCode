class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] state = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int c = pre[0], preC = pre[1];
            graph.get(preC).add(c);
        }
        for(int course = 0; course < numCourses; course++){
            if(!graphDFS(course, graph, state)){
                return false;
            }
        }
        return true;
    }
    public boolean graphDFS(int c, List<List<Integer>> graph, int[] state){
        if(state[c] == 1){
            return false;
        }
        if(state[c] == 2){
            return true;
        }
        state[c] = 1;
        for(int next : graph.get(c)){
            if(!graphDFS(next, graph, state)){
                return false;
            }
        }
        state[c] = 2;
        return true;
    }
}
