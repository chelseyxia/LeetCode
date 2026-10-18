class Solution {
    private static final int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if(grid[0][0] != 0 || grid[n - 1][m - 1] != 0){
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});
        
        while(!queue.isEmpty()){
            int[] cell = queue.remove();
            int r = cell[0];
            int c = cell[1];
            int distance = grid[r][c];
            if(r == grid.length - 1 && c == grid[0].length - 1){
                return distance;
            }
            for(int[] nei : neighbors(r, c, grid)){
                int neiRow = nei[0];
                int neiCol = nei[1];
                queue.add(new int[]{neiRow, neiCol});
                grid[neiRow][neiCol] = distance + 1;
            }
        }
        return -1;
    }
    
    public List<int[]> neighbors(int r, int c, int[][] grid){
        List<int[]> neighbors = new ArrayList<>();
        for(int i = 0; i < directions.length; i++){
            int newRow = r + directions[i][0];
            int newCol = c + directions[i][1];
            if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 0){
                continue;
            }
            neighbors.add(new int[]{newRow, newCol});
        }  
        return neighbors;
    }
}
