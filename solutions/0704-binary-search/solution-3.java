class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0; int right = n - 1;
        int i = (right - left + 1) / 2;
        while(left <= right){
            if(nums[i] < target){
                left = i + 1;
                i = (right - left + 1) / 2 + left;
            }
            else if(nums[i] > target){
                right = i - 1;
                i = (right - left + 1) / 2;
            }
            else{
                return i;
            }
            

        }
        return -1;
    }
}
