class Solution {
    public void rotate(int[] nums, int k) {
        //use addtional space?
        //if do not use addtional space?
        int n = nums.length;
        int[] newNums = new int[n];

        for(int i = 0; i < n; i++){
            newNums[(i + k) % n] = nums[i];
        }
        
        for(int j = 0; j < nums.length; j++){
            nums[j] = newNums[j];
        }
    }
}
