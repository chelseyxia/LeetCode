class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1, i = nums.length - 1;
        int[] ans = new int[nums.length];
        while(left <= right){
            int absL = Math.abs(nums[left]);
            int absR = nums[right] < 0 ? Math.abs(nums[right]) : nums[right];
            if(absL > absR){
                ans[i] = nums[left] * nums[left];
                i--;
                left++;
            }
            else{
                ans[i] = nums[right] * nums[right];
                i--;
                right--;                
            }
        }
        return ans;
    }
}
