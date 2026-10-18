class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2){
            return s;
        }
        int end = 1;
        int start = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        
        char[] charArray = s.toCharArray();
        for(int L = 2; L <= n; L++){
            for(int i = 0; i < n; i++){
                int j = L + i - 1;
                if(j >= n){
                    break;
                }
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }
                else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i + 1][j - 1];
                    } 
                }
                if(dp[i][j] & (j - i + 1) > end){
                    end = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + end);
    }
}
