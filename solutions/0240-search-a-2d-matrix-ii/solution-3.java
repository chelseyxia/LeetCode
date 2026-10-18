class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int end = matrix[0].length - 1;
        while(start >= 0 && start < n && end >= 0 && end < m){
            if(matrix[start][end] == target){
                return true;
            }
            if(matrix[start][end] < target){
                start++;
            }
            else{
                end--;
            }
        }
        return false;
    }
}
