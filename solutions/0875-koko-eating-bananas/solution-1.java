class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find the max integer
        int left = 1;
        int right = 1;
        
        for(int pile : piles){
            right = Math.max(right, pile);
        }
        
        while(left < right){
            int mid = left + (right - left) / 2;
            int hourSpent = 0;
            
            for(int pile : piles){
                hourSpent += Math.ceil((double) pile / mid);               
            }
            if(hourSpent <= h){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        
        return right;
    }
}
