class Solution {
    public int findPeakElement(int[] nums) {
        //peak elements: > nei;
        //time complexity: O(log n)
        //return the index
        int left = 0;
        int right = nums.length - 1;
        //no for loop
        int i = 0;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        
        
        return left;
    }
}
