class Solution {
    List<Integer>[] match;
    int ans;
    boolean[] vis;
    public int countArrangement(int n) {
        vis = new boolean[n + 1];
        match = new List[n + 1];
        
        for(int i = 0; i <= n; i++){
            match[i] = new ArrayList();
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i % j == 0 || j % i == 0){
                    match[i].add(j);
                }
            }
        }
        backTracking(1, n);
        return ans;
    }
    
    public void backTracking(int index, int n){
        if(index == n + 1){
            ans++;
            return;
        }
        
        for(int x : match[index]){
            if(!vis[x]){
                vis[x] = true;
                backTracking(index + 1, n);
                vis[x] = false;
            }
        }
    }
}
