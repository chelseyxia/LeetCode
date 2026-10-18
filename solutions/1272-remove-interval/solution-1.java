class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            if(end <= toBeRemoved[0] || start >= toBeRemoved[1]){
                res.add(Arrays.asList(interval[0], interval[1]));
            }
            else{
                if (start < toBeRemoved[0]){
                    res.add(Arrays.asList(start, toBeRemoved[0]));
                }
                if (end > toBeRemoved[1]){
                    res.add(Arrays.asList(toBeRemoved[1], end));                   
                }
            }
        }
        return res;
    }
}
