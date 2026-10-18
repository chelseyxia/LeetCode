class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for(int pile : piles){
            right = Math.max(pile, right);
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            int needsHour = 0;
            for(int pile : piles){
                needsHour += Math.ceil((double)pile / mid);
            }
            if(needsHour <= h){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return right;
    }
}
