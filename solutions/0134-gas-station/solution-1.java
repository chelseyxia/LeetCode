class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_cost = 0;
        int cur_cost = 0;
        int k = 0;
        for(int i = 0; i < n; ++i){
            total_cost += gas[i] - cost[i];
            cur_cost += gas[i] - cost[i];
            if(cur_cost < 0){
                k = i + 1;
                cur_cost = 0;
            }
           // k = i;
        }
        if(total_cost >= 0){
            return k;
        }
        return -1;
    }
}
