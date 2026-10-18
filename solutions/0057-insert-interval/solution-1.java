class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList();
        int i = 0;
        int n = intervals.length;
        while(i < n && (intervals[i][1] < newInterval[0])){
            ans.add(intervals[i]);
            i++;
        }
        
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(newInterval);
        while(i < n && intervals[i][0] > newInterval[1]){
            ans.add(intervals[i]);
            i++;
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}
