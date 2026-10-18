class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int n = intervals.length;
        if(n == 0){
            return 0;
        }
        int count = 1;
        int end = intervals[0][1];
        for(int i = 1; i < n; i++){
            if(intervals[i][0] >= end){
                end = intervals[i][1];
                count++;
            }
        }
        return n - count;
    }
}
