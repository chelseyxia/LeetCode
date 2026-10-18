class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int sum1 = nums[0] * nums[1] * nums[n];
        int sum2 = nums[n - 2] * nums[n - 1] * nums[n];
        return Math.max(sum1, sum2);
    }
}
