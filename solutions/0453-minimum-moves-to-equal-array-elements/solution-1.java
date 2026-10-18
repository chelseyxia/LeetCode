class Solution {
    public int minMoves(int[] nums) {
        //increment n - 1 elements by 1
        int n = nums.length;
        //first: sort the array
        Arrays.sort(nums);
        //second
        int count = 0;
        for(int i = n - 1; i > 0; i--){
            count += nums[i] - nums[0];
        }
        
        return count;
    }
}

//1,2,3,4,5
//2,3,4,5,5
//3,4,5,6,5
