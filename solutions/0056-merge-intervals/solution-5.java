class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int idx = -1;
        for(int[] interval : intervals){
            if(idx == -1 || interval[0] > res[idx][1]){
                res[++idx] = interval;
            }
            else{
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        
        return Arrays.copyOf(res, idx + 1);
    }
}
