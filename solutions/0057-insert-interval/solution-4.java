class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // if(intervals.length == 0){
        //     return new int[][]{newInterval}; 
        // } 
        // List<int[]> res = new ArrayList<>(); 
        // int[] cur = newInterval; 
        // for(int i = 0; i < intervals.length; i++){
        //     if(intervals[i][0] > cur[1] || intervals[i][1] < cur[0]){
        //         res.add(intervals[i]); 
        //     } 
        //     else{
        //         cur[0] = Math.min(cur[0], intervals[i][0]); 
        //         cur[1] = Math.max(cur[1], intervals[i][1]); 
        //     } 
        // } 
        // res.add(cur); 
        // int[][] ans = res.toArray(new int[res.size()][]); 
        // Arrays.sort(ans, (a,b) -> Integer.compare(a[0], b[0])); 
        // return ans;
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i++]);
        }
        int[] cur = newInterval.clone();
        while(i < intervals.length && cur[1] >= intervals[i][0]){
            cur[0] = Math.min(cur[0], intervals[i][0]);
            cur[1] = Math.max(cur[1], intervals[i][1]);
            i++;
        }
        res.add(cur);
        while(i < intervals.length){
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
