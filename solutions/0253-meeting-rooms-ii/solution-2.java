class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        PriorityQueue<int[]> que = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));
        for(int[] interval : intervals){
            if(!que.isEmpty() && que.peek()[1] <= interval[0]){
                que.poll();
            }
            que.add(interval);
        }
        return que.size();
    }
}
