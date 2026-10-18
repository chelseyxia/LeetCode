class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0; 
        int j = 0;
        while(true) {
            //0 1 0 3 12
            if(j < n){
                if(nums[j] != 0){
                    nums[i++] = nums[j];
                }
                j++;
            }
            else if(i < n){
                nums[i++] = 0;
            }
            else{
                break;
            }
        }
    }
}
