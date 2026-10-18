class Solution {
    public int removeDuplicates(int[] nums) {
        int fast = 0, slow = 0;
        int slowVal = nums[slow];
        while(slow <= fast && fast < nums.length){
            int cur = nums[fast];
            if(cur == slowVal){
                fast++;
                continue;
            }
            else{
                slow++;
                nums[slow] = cur;
                slowVal = nums[slow];
                fast++;
            }
        }
        return slow + 1;
    }
}
