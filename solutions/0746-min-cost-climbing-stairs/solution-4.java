class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev1 = cost[0];
        int prev2 = cost[1];
        for(int i = 2; i < n; i++){
            int tmp = prev2;
            prev2 = Math.min(cost[i] + prev1, cost[i] + prev2);
            prev1 = tmp;
        }
        return Math.min(prev1, prev2);
    }
}
