class Solution {
    public int rob(int[] nums) {
        //bottom up
        //take: robHelper(0) = nums[i] + rob
        //skip: robHelper(1) = rob;
        int rob1 = 0;
        int rob2 = 0;
        for(int i = 0; i < nums.length; i++){
            int tmp = rob2;
            rob2 = Math.max(rob1 + nums[i], rob2);
            rob1 = tmp;
        }
        return rob2;
    }
}
