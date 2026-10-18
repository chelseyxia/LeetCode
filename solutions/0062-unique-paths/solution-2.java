class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //pathpoint = (m, n - 1) / (m - 1, n)
        //dp function
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int j = 0; j < m; j++){
            dp[j][0] = 1;
        }
        if(m == 1 || n == 1){
            return 1;
        }
        for(int r = 1; r < m; r++){
            for(int c = 1; c < n; c++){
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];              
            }
        }
        return dp[m - 1][n - 1];
        
    }
}
