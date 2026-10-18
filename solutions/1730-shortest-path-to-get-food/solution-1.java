class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int getFood(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int steps = 0;
        int p_r = 0;
        int p_c = 0;
        
        boolean[][] visited = new boolean[rows][cols];
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '*'){
                    p_r = r;
                    p_c = c;
                }             
            }
        }
        
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{p_r, p_c});
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if(grid[x][y] == '#'){
                    return steps;
                }
                for(int[] d : dirs){
                    int newX = x + d[0];
                    int newY = y + d[1];
                    if(isValid(grid, newX, newY, rows, cols) && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private boolean isValid(char[][] grid, int x, int y, int m, int n){
        return x >= 0 && y >= 0 && y < n && x < m && grid[x][y] != 'X';
    }
}
