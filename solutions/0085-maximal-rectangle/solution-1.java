class Solution {
    public int maximalRectangle(char[][] matrix) {
    //dynamic programming
        //must be rectangle
        //Histograms柱状图
        //row[i] = row[i - 1] + 1 if row[i] = 1
        if(matrix.length == 0){
            return 0;
        }
        int maxArea = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                
                if(matrix[i][j] == '1'){
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int width = dp[i][j];
                    for(int k = i; k >= 0; k--){
                        width = Math.min(width, dp[k][j]);
                        maxArea = Math.max(maxArea, width * (i - k + 1));
                    }
                }
                
            }
        }
        
        
        return maxArea;
    }
}
