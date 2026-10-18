class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1;
        int i = 0; 
        int j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum < k){
                ans = Math.max(ans, sum);
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
}
