class Solution {
    public int reverse(int x) {
        List<Integer> set = new ArrayList<>();
        int a = 0, sum = 0;
        while(x != 0){
            if(sum < Integer.MIN_VALUE/10  || sum > Integer.MAX_VALUE/10 ){
                return 0;
            }
            a = x % 10;
            x /= 10;
            sum = sum * 10 + a;
        }
        return sum;
    }
}
