class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] wait = new int[n];
        int hottest = 0;
        for(int i = n - 1; i >= 0; i--){
            int currTemp = temperatures[i];
            if(currTemp >= hottest){
                hottest = currTemp;
                continue;
            }
            int days = 1;
            while(temperatures[i + days] <= currTemp){
                days += wait[i + days];
            }
            wait[i] = days;
        }
        return wait;
    }
}
