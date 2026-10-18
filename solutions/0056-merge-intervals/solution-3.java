class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int m = intervals[0].length;
        List<int[]> res = new ArrayList<>();
        
        int[] start = new int[10000];
        int[] end = new int[10000];
        
        int max = 0;
        
        for(int[] interval : intervals){
            start[interval[0]]++;
            end[interval[1]]++;
            
            if(max < interval[1]){
                max = interval[1];
            }
        }
        
        int[] range = new int[2];
        int count = 0;
        
        for(int i = 0; i <= max; i++){
            if(start[i] > 0){
                if(count == 0){
                    range[0] = i;
                }
                count += start[i];
            }
            
            if(end[i] > 0){
                count -= end[i];
                if(count == 0){
                    range[1] = i;
                    res.add(range);
                    range = new int[2];
                }
            }
        }
        
        return res.toArray(new int[0][0]);
    }
}
