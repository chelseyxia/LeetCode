class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int t1 = text1.length();
        int t2 = text2.length();
        if(t1 == 0 || t2 == 0){
            return 0;
        }
        int[][] dp = new int[t1 + 1][t2 + 1];
        for(int i = t2 - 1; i >= 0; i--){
            for(int j = t1 - 1; j >= 0; j--){
                if(text1.charAt(j) == text2.charAt(i)){
                    dp[j][i] = dp[j + 1][i + 1] + 1;
                }
                else{
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
