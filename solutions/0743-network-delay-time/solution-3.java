class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int minimumDelayTime = 0;
        int ans = Integer.MIN_VALUE;
        boolean[] visited = new boolean[n + 1];
        int visitedNode = 0;
        for(int[] time : times){
            int source = time[0];
            int target = time[1];
            int delayTime = time[2];
            if(!map.containsKey(source)){
                map.put(source, new ArrayList<>());
            }
            map.get(source).add(List.of(target, delayTime));
        }
        minHeap.offer(new int[]{k, 0});
        while(!minHeap.isEmpty()){
            int[] curNodeAndTime = minHeap.poll();
            int curTarget = curNodeAndTime[0];
            int curTime = curNodeAndTime[1];
            if(visited[curTarget]){
                continue;
            }
            visited[curTarget] = true;
            visitedNode++;
            if(visitedNode == n){
                return curTime;
            }
            if(map.get(curTarget) == null){
                continue;
            }
            List<List<Integer>> sourcesAndTime = map.get(curTarget);
            for(int i = 0; i < sourcesAndTime.size(); i++){
                int source = sourcesAndTime.get(i).get(0);
                int time = sourcesAndTime.get(i).get(1);
                minHeap.offer(new int[]{source, curTime + time});
            }

        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
