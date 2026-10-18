class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int r, int c, int rows, int cols){
        if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != '1'){
            return;
        }
        grid[r][c] = '*';
        dfs(grid, r + 1, c, rows, cols);
        dfs(grid, r - 1, c, rows, cols);
        dfs(grid, r, c + 1, rows, cols);
        dfs(grid, r, c - 1, rows, cols);
    }
}
