class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int complete = 0;
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
                int curC = queue.poll();
                complete++;
                res.add(curC);
                List<Integer> courses = list.get(curC);
                for(int j = 0; j < courses.size(); j++){
                    int course = courses.get(j);
                    indegree[course]--;
                    if(indegree[course] == 0){
                        queue.offer(course);
                    }
                }

            }
        }
        int[] ans = new int[numCourses];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return complete == numCourses ? ans : new int[0];
    }
    
}
