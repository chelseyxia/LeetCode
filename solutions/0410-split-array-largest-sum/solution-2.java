class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0, sum = 0;
        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            int curSum = 0;
            int curEle = 1;
            for(int n : nums){
                if(curSum + n > mid){
                    curEle++;
                    curSum = 0;
                }
                curSum += n;
            }
            if(curEle <= k){
                right = mid;
            }
            else{
                left = mid + 1;
            }

        }
        return left;
    }
}
