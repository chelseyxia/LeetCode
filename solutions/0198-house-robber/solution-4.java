class Solution {
    public int rob(int[] nums) {
        //base case
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        int[] maxRobber = new int[n];
        maxRobber[0] = nums[0];
        maxRobber[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            maxRobber[i] = Math.max(maxRobber[i - 2] + nums[i], maxRobber[i - 1]);
        }
        return maxRobber[n - 1];
    }
}
