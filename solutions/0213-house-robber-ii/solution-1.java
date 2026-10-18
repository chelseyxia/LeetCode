class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        int case1 = robHelper(nums, 0, nums.length - 2, memo1);// 0 - (nums.length - 2)
        int case2 = robHelper(nums, 1, nums.length - 1, memo2);// 1 - nums.length - 1
        return Math.max(case1, case2);
    }
    public int robHelper(int[] nums, int start, int end, int[] memo){
        if(start > end){
            return 0;
        }
        if(memo[start] == -1){
            memo[start] = Math.max(robHelper(nums, start+2, end, memo) + nums[start], robHelper(nums, start+1, end, memo));
        }
        return memo[start];
    }
}
