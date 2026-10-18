class Solution {
    private int[][] grid;
    private boolean[][] seen;
    private Set<Pair<Integer, Integer>> currentLand;
    private int currow;
    private int curcol;
    
    public void dfs(int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return;
        }
        if(grid[row][col] == 0 || seen[row][col]){
            return;
        }
        seen[row][col] = true;
        currentLand.add(new Pair<>(row - currow, col - curcol));
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        int nr = grid.length;
        int nc = grid[0].length;
        this.seen = new boolean[nr][nc];
        Set<Set<Pair<Integer, Integer>>> islands = new HashSet<>();
                
        for(int r = 0; r < nr; r++){
            for(int c = 0; c < nc; c++){
                this.currentLand = new HashSet<>();
                this.currow = r;
                this.curcol = c;
                dfs(r, c);
                if(!currentLand.isEmpty()){
                    islands.add(currentLand);
                }
            }
        }
        
        return islands.size();
    }

}
