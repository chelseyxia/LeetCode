class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = nums[0];
        int end = nums[n - 1];
        if(n == 1){
            return nums[0];
        }
        if(start < end){
            return nums[0];
        }
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            if(nums[mid - 1] > nums[mid]){
                return nums[mid];
            }

            if(nums[mid] > start){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
