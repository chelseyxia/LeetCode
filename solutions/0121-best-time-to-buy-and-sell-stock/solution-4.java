class Solution {
    public int maxProfit(int[] prices) {
        int start = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            start = Math.min(start, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - start);
        }
        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }
}
