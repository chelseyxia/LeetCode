class Solution {
    int[] pre;
    int total;
    public Solution(int[] w) {
        pre  = new int[w.length];
        pre[0] = w[0];
        for(int i = 1; i < w.length; i++){
            pre[i] = pre[i - 1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }
    
    public int pickIndex() {
        int x = (int)(Math.random() * total) + 1;
        return binarySearch(x);
    }
    
    private int binarySearch(int x){
        int low = 0;
        int high = pre.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(pre[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
