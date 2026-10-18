class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval}; 
        } 
        List<int[]> res = new ArrayList<>(); 
        int[] cur = newInterval; 
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] > cur[1] || intervals[i][1] < cur[0]){
                res.add(intervals[i]); 
            } 
            else{
                cur[0] = Math.min(cur[0], intervals[i][0]); 
                cur[1] = Math.max(cur[1], intervals[i][1]); 
            } 
        } 
        res.add(cur); 
        int[][] ans = res.toArray(new int[res.size()][]); 
        Arrays.sort(ans, (a,b) -> Integer.compare(a[0], b[0])); 
        return ans;
    }
}
