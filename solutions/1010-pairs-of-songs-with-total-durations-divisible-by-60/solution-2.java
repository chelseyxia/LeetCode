class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int cnt = 0;
        for(int t : time){
            if(t % 60 == 0){
                cnt += remainders[0];
            }
            else{
                cnt += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return cnt;
    }
}
