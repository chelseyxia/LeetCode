class Solution {
    public int numTilings(int n) {
        if(n < 2){
            return n;
        }
        long prevFull2 = 1;
        long prevFull1 = 2;
        long prevSemi = 1;
        long mod = 1_000_000_007;
        for(int i = 3; i <= n; i++){
            long curr = (prevFull1 + prevFull2 + (prevSemi << 1)) % mod;
            prevSemi = (prevFull2 + prevSemi) % mod;
            prevFull2 = prevFull1;
            prevFull1 = curr;
        }
        return (int)prevFull1;
    }
}
