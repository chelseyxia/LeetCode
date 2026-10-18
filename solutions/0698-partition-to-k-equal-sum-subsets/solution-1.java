class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int target = sum / k;
        int complete = sum % k;
        if(complete != 0){
            return false;
        }  
        Arrays.sort(nums);
        reverse(nums);
        boolean[] taken = new boolean[n];
        return backTracking(nums, 0, 0, 0, k, target, taken);
    }
    
    public void reverse(int[] nums){
        for(int i = 0, j = nums.length - 1; i < j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    
    public boolean backTracking(int[] nums, int index, int count, int currSum, int k, int target, boolean[] taken){
        int n = nums.length;
        if(count == k - 1){
            return true;
        }
        if(currSum > target){
            return false;
        }
        if(currSum == target){
            return backTracking(nums, 0, count + 1, 0, k, target, taken);
        }
        for(int i = index; i < n; i++){
            if(!taken[i]){
                taken[i] = true;
                if(backTracking(nums, i + 1, count, currSum + nums[i], k, target, taken)){
                    return true;
                }
                taken[i] = false;
            }
        }
        return false;
    }
}
