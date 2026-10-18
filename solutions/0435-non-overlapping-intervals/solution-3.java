class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int minNum = 0;
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        int[] cur = intervals[0].clone();
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < cur[1]){
                if(intervals[i][1] < cur[1]){
                    cur = intervals[i].clone();
                }
                minNum++;
            }
            else{
                cur = intervals[i].clone();
            }
        }

        return minNum;
    }
}
