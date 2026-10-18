class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int x = 0;
        int b = 1;
        while(b <= n){
            while(x < b && x + b <= n){
                ans[x + b] = ans[x] + 1;
                ++x;
            }
            x = 0;
            b <<= 1;
        }
        return ans;
    }
}
