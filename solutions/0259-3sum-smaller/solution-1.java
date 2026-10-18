class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            /*if(nums[i] >= target){
                break;
            }*/
            int targetsum = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int twosum = nums[left] + nums[right];
                if(twosum >= targetsum){
                    right--;
                }
                else if(twosum < targetsum){
                    ans += right - left;
                    left++;
                }
            }
        }
        return ans;
    }
}
