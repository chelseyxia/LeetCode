class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int layers = 0;
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[n+1];
        int complete = 0;
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        for(int[] rel : relations){
            int preC = rel[0];
            int nextC = rel[1];
            list.get(preC).add(nextC);
            indegree[nextC]++;
        }
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curC = queue.poll();
                complete++;
                List<Integer> courses = list.get(curC);
                for(int j = 0; j < courses.size(); j++){
                    int course = courses.get(j);
                    indegree[course]--;
                    if(indegree[course] == 0){
                        queue.offer(course);
                    }
                }
            }
            layers++;
        }

        return complete == n ? layers : -1;
    }
}
