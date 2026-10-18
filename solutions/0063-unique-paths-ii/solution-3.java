class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        if(obstacleGrid[rows - 1][cols -1] == 1 || obstacleGrid[0][0] == 1){
            return 0;
        }
        for(int r = 0; r < rows && obstacleGrid[r][0] == 0; r++){
            dp[r][0] = 1;
        }
        for(int c = 0; c < cols && obstacleGrid[0][c] == 0; c++){
            dp[0][c] = 1;
        }
        for(int r = 1; r < rows; r++){
            for(int c = 1; c < cols; c++){
                if(obstacleGrid[r][c] == 0){
                    dp[r][c] = dp[r][c - 1] + dp[r - 1][c];                 
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
