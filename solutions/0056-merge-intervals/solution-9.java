class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        List<int[]> res = new ArrayList<>();
        int[] clone = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(clone[1] >= intervals[i][0]){
                clone[0] = Math.min(clone[0], intervals[i][0]);
                clone[1] = Math.max(clone[1], intervals[i][1]);
            }
            else{
                res.add(clone);
                clone = intervals[i].clone();
            }
        }
        res.add(clone);
        return res.toArray(new int[res.size()][]);
    }
}
