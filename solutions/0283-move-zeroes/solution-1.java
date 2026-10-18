class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        while(true){
            if(j < n){
                if(nums[j] != 0){
                    nums[i++] = nums[j];
                }
                j++;
            }
            else if(i < n){
                nums[i++] = 0;
            }
            else break;
        }
    }
}
