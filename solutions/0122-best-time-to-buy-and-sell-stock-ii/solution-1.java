class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        for(int i = 1; i < n; i++){
            int newdp0 = Math.max(dp0, dp1 + prices[i]);
            int newdp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newdp0;
            dp1 = newdp1;
        } 
        return dp0;
    }
}
