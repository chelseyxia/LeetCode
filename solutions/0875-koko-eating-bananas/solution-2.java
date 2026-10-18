class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1, right = piles[piles.length - 1];
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
