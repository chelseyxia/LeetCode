class Solution {
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] state = new int[numCourses];
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int c = pre[0], preC = pre[1];
            graph.get(preC).add(c);
        }
        index = numCourses - 1;
        for(int course = 0; course < numCourses; course++){
            if(!hasNoCycle(course, state, graph, res)){
                return new int[0];
            }
        }
        return res;
    }
    public boolean hasNoCycle(int c, int[] state, List<List<Integer>> graph, int[] res){
        if(state[c] == 1){
            return false;
        }
        if(state[c] == 2){
            return true;
        }
        state[c] = 1;
        for(int next : graph.get(c)){
            if(!hasNoCycle(next, state, graph, res)){
                return false;
            }
        }
        state[c] = 2;
        res[index--] = c;
        return true;
    }
}
