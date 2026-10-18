class Solution {
    public int maxSubArray(int[] nums) {
        int curSubArray = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            curSubArray = Math.max(num, curSubArray + num);
            max = Math.max(max, curSubArray);
        }
        return max;
    }
}
