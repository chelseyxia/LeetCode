class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp1 = 0;
        int dp2 = 0;
        for(int i = 2; i <= n; i++){
            int tmp = dp1;
            dp1 = Math.min(cost[i-1] + dp1, cost[i-2] + dp2);
            dp2 = tmp;
        }
        return dp1;
    }
}
