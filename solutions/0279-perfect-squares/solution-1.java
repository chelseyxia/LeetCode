class Solution {
    public int numSquares(int n) {
        //perfect square: 1, 4, 9: Math.pow(i, 2);
        //back?: 12 -> 9 + 3? -> 4 + 8 -> 4 + 4 + 4
        //13 -> 9 + 4 -> 3 & 2 yes!
        //how to find the nearest integer?
        //26: 25 + 1
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int max_square_index = (int)Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        
        for(int i = 1; i < max_square_index; i++){
            square_nums[i] = i * i;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < max_square_index; j++){
                if(i < square_nums[j]){
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - square_nums[j]] + 1);
            }
        }
        return dp[n];
    }
}
