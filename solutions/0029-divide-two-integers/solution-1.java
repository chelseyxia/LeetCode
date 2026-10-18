class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = ((dividend ^ divisor) < 0) ? -1 : 1;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long res = 0;
        for(int i = 31; i >= 0; i--){
            if((a >> i) >= b){
                a -= (b << i);
                res += (1L << i);
            }
        }
        res = (sign == 1) ? res : -res;
        return (int)res;
    }
}
