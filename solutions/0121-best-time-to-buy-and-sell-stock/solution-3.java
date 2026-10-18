class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minStart = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(prices[i] < minStart){
                minStart = prices[i];
            }
            else{
                maxProfit = Math.max(maxProfit, prices[i] - minStart);
            }
        }
        return maxProfit;
    }
}
