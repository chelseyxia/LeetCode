class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] isZero = new boolean[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(matrix[r][c] == 0){
                    for(int i = 0; i < rows; i++){
                        isZero[i][c] = true; 
                    }
                    for(int i = 0; i < cols; i++){
                        isZero[r][i] = true;
                    }
                }
            }
        }
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(isZero[r][c] == true){
                    matrix[r][c] = 0;
                }
            }
        }       
    }
}
