class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int r, int c, boolean[][] visited){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }
        if(visited[r][c] == true){
            return;
        }
        if(grid[r][c] == '0'){
            return;
        }
        visited[r][c] = true;
        dfs(grid, r - 1, c, visited);
        dfs(grid, r, c - 1, visited);
        dfs(grid, r + 1, c, visited);
        dfs(grid, r, c + 1, visited);
    }
}
