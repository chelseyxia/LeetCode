class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        First, I sort the intervals by start time.
        Then I maintain a current interval cur.
        If the next interval overlaps with cur, I merge them by extending the end.
        Otherwise, I add cur to the result and reset cur.
        Finally, I add the last interval.

        */
        if(intervals.length == 0){
            return new int[0][];
        }
        List<int[]> res = new ArrayList<>();
        //Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] cur = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= cur[1]){
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
            else{
                res.add(cur);
                cur = intervals[i];
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }
}
