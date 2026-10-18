class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    backTracking(grid, i, j);
                }
            }
        }
        return ans;
    }
    private void backTracking(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        backTracking(grid, r + 1, c);
        backTracking(grid, r - 1, c);
        backTracking(grid, r, c + 1);
        backTracking(grid, r, c - 1);
    }
}
