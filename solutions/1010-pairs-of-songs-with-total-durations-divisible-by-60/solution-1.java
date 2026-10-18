class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int ans = 0;
        for(int t : time){
            if(t % 60 == 0){
                ans += remainders[0];
            }
            else{
                ans += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return ans;
    }
}
