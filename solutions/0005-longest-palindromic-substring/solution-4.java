class Solution {
    public String longestPalindrome(String s) {
        //palindromic: if s.length() < 2 return s
        int len = s.length();
        if(len < 2){
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        char[] arr = s.toCharArray();
        for(int i = 0; i < len; i++){
            dp[i][i] = true;//c[i] = c[i];
        }
        int begin = 0;
        int max = 1;
        for(int j = 1; j < len; j++){
            for(int i = 0; i < j; i++){
                if(arr[j] != arr[i]){
                    dp[i][j] = false;
                }
                else{
                    dp[i][j] = j - i + 1 <= 3 || dp[i + 1][j - 1];
                }
                if(dp[i][j] && j - i + 1 > max){
                    begin = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}
