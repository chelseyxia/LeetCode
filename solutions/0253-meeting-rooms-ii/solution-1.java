class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //minimum number of meeting room
        //use sort to make the 2d array from low to high, [a, b], [c,d] if b > c -> count++;
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int[] interval : intervals){
            if(!pq.isEmpty() && pq.peek()[1] <= interval[0]){
                pq.poll();
            }
            pq.add(interval);
        }
        return pq.size();
    }
}
