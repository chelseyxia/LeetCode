class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        res[n - 1] = n;
        
        for(int i = n - 2; i >= 0; i--){
            int pre = i + 1;
            while(pre != n && temperatures[i] >= temperatures[pre]){
                pre = res[pre];
            }
            res[i] = pre;
        }
        for(int i = 0; i < n; i++){
            res[i] = res[i] == n ? 0 : res[i] - i;
        }
        return res;
    }
}
