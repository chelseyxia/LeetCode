class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0){
                nums[i] = nums[i / 2];
            }
            if(i % 2 == 1){
                nums[i] = nums[(i + 1) / 2] + nums[i / 2];
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i : nums){
            ans = Math.max(ans, i);
        }
        return ans;
    }
}
