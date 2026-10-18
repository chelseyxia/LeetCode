class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 0;
        int right = 1000001;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            long sum = 0;
            for(int num : nums){
                sum += (num + mid - 1) / mid;
            }
            if(sum > threshold){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return right;
    }
}
