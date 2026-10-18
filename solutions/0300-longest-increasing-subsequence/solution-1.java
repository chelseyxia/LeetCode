class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        int ans = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        for(int c : memo){
            ans = Math.max(ans, c);
        }
        return ans;
    }
}
