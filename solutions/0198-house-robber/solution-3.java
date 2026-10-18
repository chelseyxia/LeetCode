class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] maxRobbed  = new int[nums.length];
        maxRobbed[0] = nums[0];
        maxRobbed[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            maxRobbed[i] = Math.max(maxRobbed[i - 2] + nums[i], maxRobbed[i - 1]);
        }
        return maxRobbed[nums.length - 1];
    }
}
