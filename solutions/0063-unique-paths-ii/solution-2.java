class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int right = obstacleGrid.length;
        int down = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for(int r = 1; r < right; r++){
            obstacleGrid[r][0] = (obstacleGrid[r][0] == 0 && obstacleGrid[r - 1][0] == 1) ? 1 : 0;
        }
        for(int d = 1; d < down; d++){
            obstacleGrid[0][d] = (obstacleGrid[0][d] == 0 && obstacleGrid[0][ d - 1] == 1) ? 1 : 0;
        }
        for(int r = 1; r < right; r++){
            for(int d = 1; d < down; d++){
                if(obstacleGrid[r][d] == 0){
                    obstacleGrid[r][d] =  obstacleGrid[r-1][d] + obstacleGrid[r][d-1];   
                }
                else{
                    obstacleGrid[r][d] = 0;
                }
            }
        }
        return obstacleGrid[right - 1][down - 1];
    }
}
