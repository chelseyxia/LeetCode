class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int size = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        while(i < size && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        
        while(i < size && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        
        while(i < size && intervals[i][0] > newInterval[1]){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
