class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right;
        int count = 0;
        for(right = 0; right < n; right++){
            if(nums[right] == 0){
                k--;
            }
            if(k < 0){
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }
}
