class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //binary search
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(arr[mid] < arr[mid + 1]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }
}
