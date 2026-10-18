class Solution {
    public int minCostII(int[][] costs) {
        //DP => function(min(cost[row - 1][k]) + costs[row][col] => where k != col)
        int n = costs.length, k = costs[0].length;
        //we need to find the smallest and second smallest value of each row
        int min1 = -1, min2 = -1;
        for(int row = 0; row < n; row++){
            int last1 = min1, last2 = min2;
            min1 = -1;
            min2 = -1;
            for(int col = 0; col < k; col++){
                if(col != last1){
                    costs[row][col] += last1 < 0 ? 0 : costs[row - 1][last1];
                }
                else{
                    costs[row][col] += last2 < 0 ? 0 : costs[row - 1][last2];
                }
                if(min1 < 0 || costs[row][col] < costs[row][min1]){
                    min2 = min1;
                    min1 = col;
                }
                else if(min2 < 0 || costs[row][col] < costs[row][min2]){
                    min2 = col;
                }
            }
        }
        return costs[n - 1][min1];
    }
}
