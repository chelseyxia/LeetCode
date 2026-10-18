class Solution {
    public int[] searchRange(int[] nums, int target) {
        //binary search
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        int right = nums.length - 1;
        int left = 0;
        int[] ans = new int[]{-1, -1};
        while(left <= right){
            int mid = (right - left) / 2 + left;
            int val = nums[mid];
            if(val < target){
                left = mid + 1;
            }
            if(val > target){
                right = mid - 1;
            }
            if(val == target){
                int leftDir = mid;
                while(leftDir >= left && nums[leftDir] == target){
                    ans[0] = leftDir--;
                }
                
                int rightDir = mid;
                while(rightDir <= right && nums[rightDir] == target){
                    ans[1] = rightDir++;
                }
                return ans;
            }
        }
        return ans;
    }
}
