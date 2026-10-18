class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[numCourses];
        int completed = 0;
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int preC = pre[1];
            int c = pre[0];
            list.get(preC).add(c);
            indegree[c]++;
        }
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curPreCourse = queue.poll();
                completed++;
                List<Integer> courses = list.get(curPreCourse);
                for(int j = 0; j < courses.size(); j++){
                    int course = courses.get(j);
                    indegree[course]--;
                    if(indegree[course] == 0){
                        queue.offer(course);
                    }
                }
            }
        }
        return completed == numCourses;
    }
}
