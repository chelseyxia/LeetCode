class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return maxSide;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(matrix[i][j] == '1'){
                    maxSide = Math.max(maxSide, 1);
                    int currentMaxSide = Math.min(rows - i, columns - j);
                    //不可能是max,因为是正方形， 肯定是最小边，不然会变长方形
                    for(int k = 0; k < currentMaxSide; k++){
                        boolean flag = true;
                        if(matrix[i + k][j + k] == '0'){
                            break;
                        }
                        for(int m = 0; m < k; m++){
                            if(matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            maxSide = Math.max(maxSide, k + 1);
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
