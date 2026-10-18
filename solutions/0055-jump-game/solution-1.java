class Solution {
    public boolean canJump(int[] nums) {
        int maxpos = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i > maxpos){
                return false;
            }
            maxpos = Math.max(maxpos, i + nums[i]);
        }
        return true;
    }
}
