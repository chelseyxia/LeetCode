class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]){
                Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int res = 0;
        int[] clone = intervals[0].clone();
        for(int i = 1; i < intervals.length; i++){
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];
            if(clone[1] > curLeft){
                res++;
            }
            else{
                clone = intervals[i].clone();
            }
        }
        return res;
    }
}
