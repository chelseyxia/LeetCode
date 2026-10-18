class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            else{
                return a[1] - b[1];
            }
        });
        if(intervals.length == 0){
            return 0;
        }
        int res = 1;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(start == intervals[i][0]){
                end = intervals[i][1];
            }
            else if(end < intervals[i][1]){
                start = intervals[i][0];
                end = intervals[i][1];
                res++;
            }
        }
        return res;
    }
}
