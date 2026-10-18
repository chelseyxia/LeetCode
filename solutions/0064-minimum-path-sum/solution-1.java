class Solution {
    public int minPathSum(int[][] grid) {
        int right = grid.length;
        int down = grid[0].length;
        int[][] dp = new int[right][down];
        for(int r = right - 1; r >= 0; r--){
            for(int d = down - 1; d >= 0; d--){
                if(r == right - 1 && d != down - 1){
                    dp[r][d] = grid[r][d] + dp[r][d + 1];
                }
                else if(r != right - 1 && d == down - 1){
                    dp[r][d] = grid[r][d] + dp[r + 1][d];
                }
                else if(r != right - 1 && d != down - 1){
                    dp[r][d] = grid[r][d] + Math.min(dp[r + 1][d], dp[r][d + 1]);
                }
                else{
                    dp[r][d] = grid[r][d];
                }

            }
        }
        return dp[0][0];
    }
}
