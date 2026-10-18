class Solution {
    public long mostPoints(int[][] questions) {
        /*
            Skip i:
            → 下一个考虑 i + 1

            Take i:
            → 获得 questions[i][0] points
            → 下一个考虑 i + questions[i][1] + 1
            dp(i) = 从 question i 开始一直到最后，
                    最多可以获得多少 points

        */
            int n = questions.length;
            long[] memo = new long[n+1];
            Arrays.fill(memo, -1);
            return points(questions, 0, memo);
    }
    public long points(int[][] questions, int i, long[] memo){
        if(i >= questions.length){
            return 0;
        }
        if(memo[i] == -1){
            //take: dp[i+ questions[i][1] + 1] + nums[i]
            //skip: dp[i-1]
            memo[i] = Math.max(points(questions, i + questions[i][1] + 1, memo) + questions[i][0], points(questions, i+1, memo));
        }
        return memo[i];
    }
}
