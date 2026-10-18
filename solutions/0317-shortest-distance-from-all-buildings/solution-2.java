class Solution {
    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    public int shortestDistance(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][] distSum = new int[r][c];
        int[][] reaches = new int[r][c];
        int buildings = 0;
        boolean isLand = false;
        boolean isBuilding = false;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int val = grid[i][j];
                if(val == 1){
                    buildings++;
                    isBuilding = true;
                    bfs(grid, i, j, distSum, reaches);
                }
                else if(val == 0){
                    isLand = true;
                }
            }
        }
        if(!isLand || !isBuilding){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int val = distSum[i][j];
                if(reaches[i][j] == buildings && grid[i][j] == 0){
                    res = Math.min(res, val);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public void bfs(int[][] grid, int startR, int startC, int[][] distSum, int[][] reaches){
        int r = grid.length, c = grid[0].length;
        int[][] visited = new int[r][c];
        Queue<int[]>  queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                for(int[] dir : directions){
                    int newR = dir[0] + cur[0];
                    int newC = dir[1] + cur[1];
                    if(newR < 0 || newC < 0 || newR >= r || newC >= c || grid[newR][newC] != 0 || visited[newR][newC] != 0){
                        continue;
                    }
                    visited[newR][newC] = visited[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{newR, newC});
                    reaches[newR][newC]++;
                }
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                distSum[i][j] += visited[i][j];
            }
        }
    }
}
