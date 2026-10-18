class Solution {
    public int getMaximumGold(int[][] grid) {
        int gold = 0;
        int rows = grid.length, cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                boolean[][] visited = new boolean[rows][cols];
                if(grid[i][j] != 0){
                    int sum = gridDFS(grid, i, j, visited);
                    gold = Math.max(gold, sum);
                }
            }
        }

        return gold;
    }
    public int gridDFS(int[][] grid, int r, int c, boolean[][] visited){
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length){
                return 0;
            }
            if(grid[r][c] == 0 || visited[r][c]){
                return 0;
            }
            int bestNext = 0;
            visited[r][c] = true;
            bestNext = Math.max(bestNext, gridDFS(grid, r - 1, c, visited));
            bestNext = Math.max(bestNext, gridDFS(grid, r + 1, c, visited));
            bestNext = Math.max(bestNext, gridDFS(grid, r, c + 1, visited));
            bestNext = Math.max(bestNext, gridDFS(grid, r, c - 1, visited));
            visited[r][c] = false;
            return grid[r][c] + bestNext;
    }
}
