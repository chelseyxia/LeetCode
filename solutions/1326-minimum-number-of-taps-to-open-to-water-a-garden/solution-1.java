class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] region = new int[n + 1][2];
        //transfer the tap's address to the range of water
        for(int i = 0; i <= n; i++){
            int[] temp = new int[2];
            temp[0] = Math.max(0, i - ranges[i]);
            temp[1] = Math.min(n, i + ranges[i]);
            region[i] = temp;
        }
        
        //ascending from left to right
        Arrays.sort(region, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int res = 0;
        int right = 0;
        int cur = 0;
        
        while(cur < n + 1){
            if(region[cur][0] > right){
                break;
            }
            int rt = right;
            
            while(cur < n + 1 && region[cur][0] <= right){
                rt = Math.max(rt, region[cur][1]);
                cur++;
            }
            res++;
            right = rt;
            if(right == n){
                break;
            }
        }
        
        return right == n ? res : -1;
        
    }
}
