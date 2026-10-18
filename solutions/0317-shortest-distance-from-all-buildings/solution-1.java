class Solution {
    private int bfs(int[][] grid, int row, int col, int totalHouse){
        int[][] dirs = {{1, 0}, {-1, 0}, { 0, 1}, {0, -1}};
        int rows = grid.length;
        int cols = grid[0].length;
        int distanceSum = 0;
        int housereached = 0;
        
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{row, col});
        boolean[][] visited = new boolean[rows][cols];
        visited[row][col] = true;
        int steps = 0;
        
        while(!queue.isEmpty() && housereached != totalHouse){
            for(int i = queue.size(); i > 0; i--){
                int[] curr = queue.poll();
                row = curr[0];
                col = curr[1];
                
                if(grid[row][col] == 1){
                    distanceSum += steps;
                    housereached++;
                    continue;
                }
                
                for(int[] dir : dirs){
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    if(nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols){
                        if(!visited[nextRow][nextCol] && grid[nextRow][nextCol] != 2){
                            visited[nextRow][nextCol] = true;
                            queue.offer(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }
            steps++;
        }
        if(housereached != totalHouse){
            for(row = 0; row < rows; row++){
                for(col = 0; col < cols; col++){
                    if(grid[row][col] == 0 && visited[row][col]){
                        grid[row][col] = 2;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
        return distanceSum;
    }
    
    public int shortestDistance(int[][] grid) {
        int minDistance = Integer.MAX_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        int totalHouse = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    totalHouse++;
                }
            }
        }
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 0){
                    minDistance = Math.min(minDistance, bfs(grid, r, c, totalHouse));
                }
            }
        }       
        
        if(minDistance == Integer.MAX_VALUE){
            return -1;
        }
        return minDistance;
    }
};
