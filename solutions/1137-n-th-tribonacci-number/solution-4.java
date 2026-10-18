class Solution {
    int[] cache = new int[40];
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        int ans = 0;
        int temp = 0;
        int pre = 1;
        int pre1 = 1;
        for(int i = 3; i <= n; i++){
            ans = temp + pre + pre1;
            temp = pre;
            pre = pre1;
            pre1 = ans;
        }
        return ans;
    }
}
