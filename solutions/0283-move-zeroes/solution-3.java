class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        while(true){
            if(j < n){
                if(nums[j] != 0){
                    nums[i++] = nums[j];
                }
                j++;
            }
            else if(i < n){
                nums[i] = 0;
                i++;
            }
            else{
                break;
            }
        }
    }
}
