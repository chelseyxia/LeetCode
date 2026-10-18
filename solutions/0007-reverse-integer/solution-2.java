class Solution {
    public int reverse(int x) {
        int ans = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if(x == 0){
            return 0;
        }
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if(ans > max / 10 || (ans == max / 10 && pop > 7)){
                return 0;
            }
            if(ans < min / 10 || (ans == min / 10 && pop < -8)){
                return 0;
            }

            ans = ans * 10 + pop;
        }
        return ans;
    }
}
