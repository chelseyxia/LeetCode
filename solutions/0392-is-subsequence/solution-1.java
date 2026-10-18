class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int n1 = s.length();
        int n2 = t.length();
        int[][] memo = new int[n1 + 1][n2 + 1];
        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                }
                else{
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
                }
                if(memo[n1][n2] == n1){
                    return true;
                }
            }
        }
        return false;
    }
}
