class Solution {
    public int[] sortArray(int[] nums) {
        //quick sort
        randomQuickSort(0, nums.length - 1, nums);
        return nums;
    }
    
    private void randomQuickSort(int left, int right, int[] nums){
        //base condition
        if(left < right){
            //find the pivot
            int pos = randomPartition(left, right, nums);
            //recursion
            randomQuickSort(left, pos - 1, nums);
            randomQuickSort(pos + 1, right, nums);
        }
    }
    
    private int randomPartition(int left, int right, int[] nums){
        //select randomly
        int i = new Random().nextInt(right - left + 1) + left;
        swap(nums, right, i);
        return partition(nums, left, right);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int i = left - 1;
        for(int j = left; j <= right - 1; ++j){
            if(nums[j] <= pivot){
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }
}
