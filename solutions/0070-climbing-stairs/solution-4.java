class Solution {
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        int ans = 0;
        int first = 1;
        int next = 1;
        for(int i = 2; i <= n; i++){
            ans = first + next;
            first = next;
            next = ans;
        }
        return ans;
    }
}
