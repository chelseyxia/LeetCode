class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0; i < n - 1; i++){
            int idx = warmer(temperatures, temperatures[i], i + 1);
            res[i] = idx;
        }
        if(temperatures[n - 2] < temperatures[n - 1]){
            res[n - 2] = 1;
        }
        res[n - 1] = 0;
        return res;
    }
    private int warmer(int[] temps, int t, int start){
        for(int i = start; i < temps.length; i++){
            //int count = 0;
            if(temps[i] > t){
                return i - start + 1;
            }
        }
        return 0;
    }
}
