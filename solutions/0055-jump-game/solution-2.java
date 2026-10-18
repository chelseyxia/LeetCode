class Solution {
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for(int i = end; i >= 0; i--){
            if(nums[i] >= end - i){
                end = i;
            }
        }
        return end == 0;
    }
}
