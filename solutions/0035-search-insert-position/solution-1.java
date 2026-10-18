class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0; 
        int high = nums.length - 1;

        while(low <= high){
            int pivot = low + (high - low) / 2;      
            if(nums[pivot] == target){
                return pivot;
            }
            if(nums[pivot] > target){
                high = pivot - 1;
            }
            else{
                low = pivot + 1;
            }
        }
        return low;
    }
}
