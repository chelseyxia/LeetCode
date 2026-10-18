class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<int[]>();
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            if(s <= prev[1]){//[0,2][2, 6]
                if(e > prev[1]){
                    prev[1] = e;
                }
            }
            else{
                list.add(prev);
                prev = intervals[i];
            }
        }
        list.add(prev);
        return list.toArray(new int[list.size()][]);
    }
}
