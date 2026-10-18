class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        int k = 1;
        while(slow <= fast && fast < nums.length){
            if(nums[fast] == 0){
                fast++;
                continue;
            }
            else{
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        for(int i = slow; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
