class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0, sum = 0, sum1 = 0;
        for(int i = 0; i < n + 1; i++){
            sum += i;
        }
        for(int i = 0; i < n; i++){
            sum1 += nums[i];
        }
        ans = sum - sum1;
        return ans;
    }
}
