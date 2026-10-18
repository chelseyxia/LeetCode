class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for(int pile : piles){
            right = Math.max(right, pile);
        }
        while(left < right){
            int k = left + (right - left) / 2;
            int sumK = 0;
            for(int pile : piles){
                sumK += Math.ceil((double) pile / k);
            }
            if(sumK <= h){
                right = k;
            }
            else{
                left = k + 1;
            }
        }
        return right;
    }
}
