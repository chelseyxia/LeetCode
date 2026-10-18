class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //every diagonal from top-left to bottom-right has same elements
        int n = matrix.length;
        int m = matrix[0].length;
        
        //int i = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
