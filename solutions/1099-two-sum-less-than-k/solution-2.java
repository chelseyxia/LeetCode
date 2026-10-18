class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0; int right = nums.length - 1;
        int sum = -1;
        while(left < right){
            int answer = nums[left] + nums[right];
            if(answer < k){
                sum = Math.max(sum, answer);
                left++;
            }
            else{
                right--;
            }
        }
        return sum;
    }
}
