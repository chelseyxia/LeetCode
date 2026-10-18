class Solution {
    public int countDigitOne(int n) {
        //1, 10, 11, 12, 13
        //个
        //十
        //百
        //千。。。
        long mulk = 1;
        int ans = 0;
        
        for(int k = 0; n >= mulk; ++k){
           ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        
        return ans;
    }
}
