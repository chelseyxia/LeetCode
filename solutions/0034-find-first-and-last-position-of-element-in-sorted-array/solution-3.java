class Solution {
    public int[] searchRange(int[] nums, int target) {
        int mostL = lowerBound(nums, target);
        int mostR = upperBound(nums, target);
        return new int[]{mostL, mostR};
    }
    public int lowerBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int mostLeft = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int numsM = nums[mid];
            if(numsM < target){
                left = mid + 1;
            }
            else if(numsM > target){
                right = mid - 1;
            }
            else{
                right = mid - 1;
                mostLeft = Math.min(mostLeft, mid);
            }
        }
        return mostLeft == Integer.MAX_VALUE ? -1 : mostLeft;
    }
    public int upperBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int mostRight = Integer.MIN_VALUE;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int numsM = nums[mid];
            if(numsM < target){
                left = mid + 1;
            }
            else if(numsM > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
                mostRight = Math.max(mostRight, mid);
            }
        }
        return mostRight == Integer.MIN_VALUE ? -1 : mostRight;
    }
}
