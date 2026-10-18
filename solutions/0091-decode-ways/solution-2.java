class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if(s.charAt(0) != '0'){
            dp[1] = 1;
        }
        
        for(int i = 2; i <= s.length(); i++){
            if(s.charAt(i - 1) != '0'){
                dp[i] = dp[i - 1];
            }
            int val = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if(val >= 10 && val <= 26){
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}
//AAJF: 1 1 10 6
//KJF: 16 10 6
//26 lettter -> 26 numbers
//12: AB / l
//226: 2 2 6/ 2 26/ 22 6
