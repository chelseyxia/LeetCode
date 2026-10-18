class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for(int w : weights){
            left = Math.max(left, w);
            right += w;
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            int curDay = 1;
            int curLoad = 0;
            for(int w : weights){
                if(curLoad + w > mid){
                    curDay++;
                    curLoad = 0;
                }
                curLoad += w;
            }
            if(curDay <= days){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}
