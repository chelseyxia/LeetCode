class Solution {
    public int numIslands(char[][] grid) {
        //dfs
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int row, int col){
        int nr = grid.length;
        int nc = grid[0].length;
        if(row < 0 || col < 0 || row >= nr || col >= nc || grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
