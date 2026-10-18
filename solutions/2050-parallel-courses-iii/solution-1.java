class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int res = 0;
        //we need to learn the 1st course to start, which means the indegree is 0
        //Queue stores courses whose all prerequisites have been completed/processed,
        //so their earliest completion time is now finalized.
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int[] indegrees = new int[n+1];
        int[] finishTime = new int[n+1];
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        for(int[] rel : relations){
            int preC = rel[0], nextC = rel[1];
            list.get(preC).add(nextC);
            indegrees[nextC]++;
        }
        for(int i = 1; i <= n; i++){
            if(indegrees[i] == 0){
                queue.offer(i);
                finishTime[i] = time[i-1];
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curC = queue.poll();
                res = Math.max(res, finishTime[curC]);
                List<Integer> courses = list.get(curC);
                for(int j = 0; j < courses.size(); j++){
                    int course = courses.get(j);
                    finishTime[course] = Math.max(finishTime[course], finishTime[curC] + time[course - 1]);
                    res = Math.max(res, finishTime[curC]);
                    indegrees[course]--;
                    if(indegrees[course] == 0){
                        queue.offer(course);
                    }
                }
            }
        }
        return res;
    }
}
