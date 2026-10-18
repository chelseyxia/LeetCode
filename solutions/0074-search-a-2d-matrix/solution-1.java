class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchColumn(matrix, target);
        if(rowIndex < 0){
            return false;
        }
        int row = matrix.length;
        if(row == 0){
            return false;
        }
        int column = matrix[0].length;        
        return binarySearch(matrix[rowIndex], target);       
    }
    public int binarySearchColumn(int[][] matrix, int target){
        int low = -1;
        int high = matrix.length - 1;
        while(low < high){
            int mid = (high - low + 1) / 2 + low;
            if(matrix[mid][0] <= target){
                low = mid;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    public boolean binarySearch(int[] row, int target){
        int l = 0;
        int h = row.length - 1;
        while(l <= h){
            int pivot = l + (h - l) / 2;
            if(row[pivot] == target){
                return true;
            }
            if(row[pivot] > target){
                h = pivot - 1;
            }
            else{
                l = pivot + 1;
            }
        }
        return false;
    }
}
