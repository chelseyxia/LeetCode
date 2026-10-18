class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;
        if(k > nums.length){
            return nums.length;
        }
        int slow = k;
        for(int fast = k; fast < nums.length; fast++){
            if(nums[fast] != nums[slow - k]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
