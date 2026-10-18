class Solution {
    public boolean isHappy(int n) {
        int gay = n;
        while(gay != 1 && gay != 4){
            gay = sum(gay);
        }
        if(gay == 1){
            return true;
        }
        return false;
        
    }
    private int sum(int n){
        int sum = 0;
        
        while(n != 0){
            int mod = n % 10;
            sum += mod * mod;
            n /= 10;        
        }
        return sum;
    }
}
