class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new ArrayDeque();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        boolean isOcean = false;
        int[] row = {0, 0, 1, -1};
        int[] col = {1, -1, 0, 0};
        int[] point = null;
        while(!queue.isEmpty()){
            point = queue.poll();
            int x = point[0];
            int y = point[1];
            for(int i = 0; i < 4; i++){
                int newx = x + row[i];
                int newy = y + col[i];
                if(newx >= n  || newy >= m || newx < 0 || newy < 0 || grid[newx][newy] != 0){
                    continue;
                } 
                grid[newx][newy] = grid[x][y] + 1;
                isOcean = true;
                queue.offer(new int[]{newx, newy});
            }
        }
        if(point == null || !isOcean){
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }
}
