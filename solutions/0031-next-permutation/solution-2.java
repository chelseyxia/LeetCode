class Solution {
    public void nextPermutation(int[] nums) {
        //the next permutation of nums which that bigger than this nums
        //when do the swap operation?
        //we can consider this question to be a graph question. and we do swap at the last peek.
        //firstly, we find the first small value a at left and second small value which is the first value bigger than a and swap them. 
        //second, we sort values at the right of a
        //this question is checking the logic of graph and how to swap an array in specific conditions
        int n = nums.length;
        if(n == 1){
            return;
        }
        int i = 1; 
        int lastIncrementIndex = -1;
        while(i < n){
            if(nums[i] > nums[i - 1]){
                lastIncrementIndex = i;
            }
            i++;
        }
        if(lastIncrementIndex == -1){
            for(int j= 0;  j < n / 2; j++){
                //swap(nums[j], nums[n - j - 1]);
                swap(j, n - j - 1, nums);
            }
            return;
        }
        int indexStart = lastIncrementIndex;
        for(i = lastIncrementIndex; i < n; i++){
            if(nums[i] > nums[lastIncrementIndex - 1] && nums[i] < nums[indexStart]){
                indexStart = i;
            }
            //break;
        }
        //swap(nums[lastIncrementIndex - 1], nums[indexStart]);
        swap(lastIncrementIndex - 1, indexStart, nums);
        Arrays.sort(nums, lastIncrementIndex, n);
    }
    
    private void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b]; 
        nums[b] = temp;
    }
}
