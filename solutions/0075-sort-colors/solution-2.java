class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = 0;
        for(int num : nums){
            if(num == 0){
                i++;
            }
            else if(num == 1){
                j++;
            }
            else if(num == 2){
                k++;
            }
        }
        for(int z = 0; z < i; z++){
            nums[z] = 0;
        }
        for(int z = i; z < i + j; z++){
            nums[z] = 1;
        }
        for(int z = i + j; z < i + j + k; z++){
            nums[z] = 2;
        }
    }
}
