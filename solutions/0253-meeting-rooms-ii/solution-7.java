class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < intervals.length; i++){
            if(!minHeap.isEmpty()){
                if(intervals[i][0] >= minHeap.peek()){
                    minHeap.poll();
                }
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }
}
