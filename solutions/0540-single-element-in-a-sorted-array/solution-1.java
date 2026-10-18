class Solution {
    public int singleNonDuplicate(int[] nums) {
        //o(log(n)) time and o(1) space
        int n = nums.length;
        int i = 0;
        while(i < n - 1){
            if(nums[i] == nums[i + 1]){
                i += 2;
            }
            else{
                break;
            }
        }
        return nums[i];
    }
}
