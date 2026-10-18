class Solution {
    public int rob(int[] nums) {
        //top down
        //Take = nums[i] + rob(i+2)
        //Skip = rob(i+1)
        // rob(i) = Math.max(Take, Skip)
        //base case
        int n = nums.length;
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        return robHelper(nums, n-1, memo);
    }
    public int robHelper(int[] nums, int i, int[] memo){
        if(i < 0){
            return 0;
        }
        if(memo[i] == -1){
            memo[i] = Math.max(robHelper(nums, i-2, memo) + nums[i], robHelper(nums, i-1, memo));
        }
        return memo[i];
    }
}
