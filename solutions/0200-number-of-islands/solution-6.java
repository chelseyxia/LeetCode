class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                int k = grid[r][c];
                if(k == '1'){
                    cnt++;
                    backTracking(grid, r, c);
                }
            }
        }
        return cnt;
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
