class Solution {
    
    List<String> ans = new ArrayList();
    String s;
    int n;
    int t;
    
    public List<String> addOperators(String num, int target) {
        // + - *
        //backtrack
        s = num;
        n = s.length();
        t = target;
        dfs(0, 0, 0, "");
        return ans;
    }
    
    private void dfs(int u, long prev, long cur, String ss){
        //base case;
        if(u == n){
            if(cur == t){
                ans.add(ss);
            }
            return;
        }
        
        for(int i = u; i < n; i++){
            //special case: 0
            if(i != u && s.charAt(u) == '0'){
                break;
            }
            long next = Long.parseLong(s.substring(u, i + 1));
            if(u == 0){
                dfs(i + 1, next, next, "" + next);
            }
            else{
                dfs(i + 1, next, cur + next, ss + "+" + next);
                dfs(i + 1, -next, cur - next, ss + "-" + next);
                long x = prev * next;
                dfs(i + 1, x, cur - prev + x, ss + "*" + next);
            }
        }
    }
}
