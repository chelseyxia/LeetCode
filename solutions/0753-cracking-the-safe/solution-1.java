class Solution {
    Set<Integer> seen = new HashSet();
    StringBuilder sb = new StringBuilder();
    int highest;
    int k;
    
    public String crackSafe(int n, int k) {
        //n digits: 0 -> (k - 1)
        highest = (int)Math.pow(10, n - 1);
        this.k = k;
        dfs(0);
        for(int i = 1; i < n; i++){
            sb.append('0');
        }
        return sb.toString();
    }
    
    private void dfs(int node){
        for(int x = 0; x < k; x++){
            int nei = node*10 + x;
            if(!seen.contains(nei)){
                seen.add(nei);
                dfs(nei % highest);
                sb.append(x);
            }
        }
    }
}
