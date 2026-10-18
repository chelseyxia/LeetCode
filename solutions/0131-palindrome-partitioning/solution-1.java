class Solution {
    public List<List<String>> partition(String s) {
        //every subString is palindrome
        //
        char[] s_array = s.toCharArray();
        List<List<String>> ans = new ArrayList();
        
        //dynamic programming
        if(s.length() == 0){
            return ans;
        }
        
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int right = 0; right < s.length(); right++){
            for(int left = 0; left <= right; left++){
                if(s_array[left] == s_array[right] && (right - left <= 2 || dp[left + 1][right - 1])){
                    dp[left][right] = true;
                }
            }
        }
        
        Deque<String> stack = new ArrayDeque();
        dfs(s, 0, s.length(), dp, stack, ans);
        
        return ans;
    }
    
    private void dfs(String s, int index, int len, boolean[][] dp, Deque<String> path, List<List<String>> res){
        if(index == len){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = index; i < len; i++){
            if(dp[index][i]){
                path.addLast(s.substring(index, i + 1));
                dfs(s, i + 1, len, dp, path, res);
                path.removeLast();
            }
        }
    }
}
