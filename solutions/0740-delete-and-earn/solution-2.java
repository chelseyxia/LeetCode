class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
        }
        int res = 0;
        int[] points = new int[max+1];
        for(int i = 0; i < n; i++){
            points[nums[i]] += nums[i];
        }
        int[] memo = new int[max+2];
        Arrays.fill(memo, -1);
        return earn(memo, max, points);
    }
    public int earn(int[] memo, int i, int[] points){
        if(i < 1){
            return 0;
        }
        if(memo[i] == -1){
            memo[i] = Math.max(earn(memo, i-2, points) + points[i], earn(memo, i-1, points));
        }
        return memo[i];
    }
}
