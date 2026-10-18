class Solution {
    int cnt = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return cnt;
    }
    private void dfs(int[] nums, int target, int idx, int s){
        if(idx == nums.length){
            if(target == s){
                cnt++;
            }
        }
        else{
            dfs(nums, target, idx + 1, s + nums[idx]);
            dfs(nums, target, idx + 1, s - nums[idx]);
        }
    }
}
