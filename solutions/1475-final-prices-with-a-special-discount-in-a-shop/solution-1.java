class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i] = prices[i] - prices[stack.peek()];
            }
            else{
                ans[i] = prices[i];
            }
            stack.push(i);

        }
        return ans;
    }
}
