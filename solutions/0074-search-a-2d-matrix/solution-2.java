class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] > target){
                right = mid - 1;
            }
            else if(matrix[mid][matrix[mid].length - 1] < target){
                left = mid + 1;
            }
            else if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target){
                int l = 0, r = matrix[mid].length - 1;
                while(l <= r){
                    int m = l + (r - l) / 2;
                    int mm = matrix[mid][m];
                    if(mm < target){
                        l = m + 1;

                    }
                    else if(mm > target){
                        r = m - 1;
                    }
                    else{
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
