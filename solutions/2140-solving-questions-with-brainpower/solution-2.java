class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];
        dp[n] = 0;
        for(int i = n-1; i >= 0; i--){
            int tmp = i + questions[i][1] + 1;
            long tmpPoints = 0;
            if(tmp > n){
                tmpPoints = 0;
            }
            else{
                tmpPoints = dp[tmp];
            }
            dp[i] = Math.max(dp[i+1], tmpPoints + questions[i][0]);
        }
        return dp[0];
    }
}
