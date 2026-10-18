class Solution {
    int[][] grid;
    boolean[][] seen;
    public int area(int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || seen[r][c] || grid[r][c] == 0){
            return 0;
        }
        seen[r][c] = true;
        return (1 + area(r + 1, c) + area(r - 1, c) + area(r, c + 1) + area(r, c - 1));
    }
    public int maxAreaOfIsland(int[][] grid) {
        /*int n = grid.length;
        int m = grid[0].length;
        int area = Integer.MIN_VALUE;
        int temp_area = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    temp_area++;
                }
                area = Math.max(area, temp_area);
            }
        }
        return area;*/
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }
}
