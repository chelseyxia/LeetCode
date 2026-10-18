class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, res = Integer.MAX_VALUE, curSum = 0;
        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
            while(curSum >= target){
                res = Math.min(res, i - left + 1);
                curSum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
