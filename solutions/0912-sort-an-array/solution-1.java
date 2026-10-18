class Solution {
    public int[] sortArray(int[] nums) {
        //bucket sort
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int len = max - min;
        int[] bucket = new int[len + 1];
        
        for(int A : nums){
            bucket[A - min]++;
        }
        
        for(int i = 0, j = 0; i <= len && j < nums.length; i++){
            while(bucket[i]-- != 0){
                nums[j++] = i + min;
            }
        }
        return nums;
    }
}
