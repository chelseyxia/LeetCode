class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int j = 0;
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                l++;
            }
            if(nums[i] == 1){
                j++;
            }
            if(nums[i] == 2){
                k++;
            }
        }
        for(int i = 0; i < l; i++){
            nums[i] = 0;
        }
        for(int i = l; i < l + j; i++){
            nums[i] = 1;
        }
        for(int i = j + l; i < l + j + k; i++){
            nums[i] = 2;
        }
    }
}
