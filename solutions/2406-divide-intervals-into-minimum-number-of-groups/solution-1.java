class Solution {
    public int minGroups(int[][] intervals) {
        /*
        我们不关心每个 group 里面有哪些 interval，
        我们只关心每个 group 当前什么时候结束。 - 
        */
        // 数据结构，支持频繁获取当前最小值，并且在插入新值后仍然保持有序 - priority queue
        if(intervals.length == 1){
            return 1;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> group = new PriorityQueue<>();
        group.offer(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > group.peek()){
                group.poll();
            }
            group.offer(intervals[i][1]);
        }
        return group.size();
    }
}
