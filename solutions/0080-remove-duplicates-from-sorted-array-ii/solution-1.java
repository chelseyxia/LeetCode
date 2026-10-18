class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1, fre = 1;
        while(slow <= fast && fast < nums.length){
            int cur = nums[fast];
            if(nums[slow] == nums[fast] && fre < 2){
                fast++;
                fre++;
                slow++;
                nums[slow] = cur;
                continue;
            }
            else if(nums[slow] != nums[fast]){
                fre = 1;
                slow++;
                nums[slow] = cur;
                fast++;
            }
            else if(nums[slow] == nums[fast] && fre >= 2){
                fast++;
                fre++;
                continue;
            }
        }
        return slow + 1;
    }
}
