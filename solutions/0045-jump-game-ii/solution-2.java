class Solution {
    public int jump(int[] nums) {
        int maxpos = 0;
        int end = 0;
        int steps = 0;
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
                maxpos = Math.max(maxpos, i + nums[i]);
            if(i == end){
                end = maxpos;
                steps++;    
            }
        } 
        return steps;
    }
}
