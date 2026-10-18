class Solution {
    public int[][] merge(int[][] intervals) {
        //intervals = [[1,3],[2,6],[8,10],[15,18]]
        //[[1,6],[8,10],[15,18]]
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for(int[] interval : intervals){
            //if res is empty || nooverlap
            if(idx == -1 || res[idx][1] < interval[0]){
                res[++idx] = interval;
            }
            else{
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
