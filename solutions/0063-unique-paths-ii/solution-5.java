class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];
        for(int i = n-1; i >= 0; i--){
            if(obstacleGrid[m-1][i] != 1){
                dp[i] = 1;
            }
            else{
                break;
            }
        }
        for(int i = m-2; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }
                else{
                    dp[j] = dp[j] + dp[j + 1];
                }
            }
        }
        return dp[0];
    }
}
