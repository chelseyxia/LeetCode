class Solution {
    public int maxStudents(char[][] seats) {
        //#broken; 
        //.: not broken
        //left/ right/ upper left/ upper right
        //cannot see front/ behind
        
        //if upper + down -> 2
        //dynamic programming
        int m = seats.length;
        int n = seats[0].length;
        int[][] dp = new int[m + 1][1 << n];
        for(int i = 1; i <= m; i++){
            int invalid = 0;
            for(int j = 0; j < n; j++){
                if(seats[i - 1][j] == '#'){
                    invalid |= 1 << j;
                }
            }
            for(int j = 0; j < (1 << n); j++){
                int adjacentMask = j << 1;
                if((j & invalid) != 0 || (j & adjacentMask) != 0){
                    dp[i][j] = -1;
                    continue;
                }
                
                int theOtherAdjacentMask = j >>> 1;
                for(int s = 0; s < (1 << n); s++){
                    if(dp[i - 1][s] == -1){
                        continue;
                    }
                    if((s & adjacentMask) != 0 || (s & theOtherAdjacentMask) != 0){
                        continue;
                    }
                    
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][s] + Integer.bitCount(j));
                }
            }
        }
        return IntStream.of(dp[m]).max().getAsInt();
    }
}
