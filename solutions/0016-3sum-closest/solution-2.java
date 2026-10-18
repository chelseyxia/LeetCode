class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        if(nums.length < 3){
            return 0;
        }
        for(int i = 0; i < nums.length && ans != 0; i++){
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(Math.abs(target - sum) < Math.abs(ans)){
                    ans = target - sum;
                }
                if(sum < target){
                    low++;
                }
                else{
                    high--;
                }
                
            }
        }
     
        return target - ans;
    }
}
