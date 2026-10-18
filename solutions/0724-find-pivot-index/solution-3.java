class Solution {
    public int pivotIndex(int[] nums) {
        int prefixsum = 0;
        for(int i = 0; i < nums.length; i++){
            prefixsum += nums[i];
        }
        int tempsum = 0;
        for(int i = 0; i < nums.length; i++){
            //prefixsum
            if(tempsum == prefixsum - tempsum - nums[i]){
                return i;
            }
            tempsum += nums[i];
        }
        return -1;
    }
}
