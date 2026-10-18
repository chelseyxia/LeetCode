class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int weight : weights){
            max = Math.max(max, weight);
            sum += weight;
        }
        int l = max; 
        int r = sum;
        //start binary search
        while(l < r){
            int mid = l + r >> 1;
            if(check(weights, mid, days)){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        
        return r;
    }
    
    private boolean check(int[] ws, int t, int d){
        int n = ws.length;
        int cnt = 1;
        for(int i = 1, sum = ws[0]; i < n; sum = 0, cnt++){
            while(i < n && sum + ws[i] <= t){
                sum += ws[i];
                i++;
            }
        }
        
        return cnt - 1 <= d;
    }
}
