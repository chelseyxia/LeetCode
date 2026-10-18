class Solution {
    int[] cache = new int[40];
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        int temp = 0; 
        int pre1 = 1; 
        int pre2 = 1;
        int ans = 0;
        for(int i = 3; i <= n; i++){
            ans = temp + pre1 + pre2;
            int t1 = pre1;
            temp = pre1;
            pre1 = pre2;
            pre2 = ans;; 
        }
        return ans;
    }
}
