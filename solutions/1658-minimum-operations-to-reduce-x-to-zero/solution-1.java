class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        int target = totalSum - x;
        int left = 0, right = 0;
        int curSum = 0;
        int n = nums.length;
        int steps = Integer.MAX_VALUE;
        while(right < n){
            curSum += nums[right];
            while(curSum > target && left <= right){
                curSum -= nums[left];
                left++;
            }
            if(curSum == target){
                steps = Math.min(steps, n - (right - left + 1));
            }
            right++;
        }
        return steps == Integer.MAX_VALUE ? -1 : steps;
    }
}
