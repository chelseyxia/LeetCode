class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(i == n - 1 && j != m - 1){
                    //edge condition
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                }
                else if(i != n - 1 && j == m - 1){
                    grid[i][j] = grid[i + 1][j] + grid[i][j];
                }
                else if(i != n - 1 && j != m - 1){
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }
}
