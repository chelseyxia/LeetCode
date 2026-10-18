class Solution {
    public int largestPerimeter(int[] nums) {
        //a + b > c
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i > 1; i--){
            if(nums[i - 1] + nums[i-2] > nums[i]){
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
