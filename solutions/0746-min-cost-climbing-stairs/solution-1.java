class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int upone = 0;
        int uptwo = 0;
        for(int i = 2; i < n + 1; i++){
            int temp = upone;
            upone = Math.min(upone + cost[i - 1], uptwo + cost[i - 2]);                
            uptwo = temp;   
        }
        return upone;
    }
}
