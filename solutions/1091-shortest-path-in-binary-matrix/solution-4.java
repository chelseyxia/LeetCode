class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int res = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1){
            return -1;
        }
        visited[0][0] = true;
        int[][] dirs = {
            {1, 1},   // 1. Diagonal Down-Right (Best overall move toward target)
            {1, 0},   // 2. Straight Down
            {0, 1},   // 3. Straight Right
            {1, -1},  // 4. Diagonal Down-Left
            {-1, 1},  // 5. Diagonal Up-Right
            {0, -1},  // 6. Straight Left
            {-1, 0},  // 7. Straight Up
            {-1, -1}  // 8. Diagonal Up-Left (Worst overall move away from target)
        };
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1];
                if(r == grid.length - 1 && c == grid[0].length - 1){
                    return res;
                }
                for(int[] dir : dirs){
                    int nr = r + dir[0], nc = c + dir[1];
                    if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length){
                        continue;
                    }
                    if(grid[nr][nc] == 1 || visited[nr][nc]){
                        continue;
                    }
                    if(grid[nr][nc] == 0 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        grid[nr][nc] = grid[r][c] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            res++;
        }
        return -1;
    }
}
