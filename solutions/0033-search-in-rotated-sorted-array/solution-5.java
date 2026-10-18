class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int left = 0, right = n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){
                if(nums[mid] >= target && nums[left] <= target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else if(nums[mid] <= nums[right]){
                //if(nums[mid] <= target && nums[right] >= target){
                if(nums[right] >= target && target >= nums[mid]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
