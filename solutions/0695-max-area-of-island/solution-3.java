class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int curArea = dfs(grid, i, j, visited);
                    area = Math.max(area, curArea);
                }
            }
        }
        return area;
    }
    public int dfs(int[][] grid, int r, int c, boolean[][] visited){
        int count = 1;
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return 0;
        }
        if(visited[r][c] || grid[r][c] == 0){
            return 0;
        }
        visited[r][c] = true;
        count += dfs(grid, r - 1, c, visited);
        count += dfs(grid, r + 1, c, visited);
        count += dfs(grid, r, c - 1, visited);
        count += dfs(grid, r, c + 1, visited);
        return count;
    }
}
