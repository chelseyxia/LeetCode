class Solution {
    public int orangesRotting(int[][] grid) {
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1];
                if(r - 1 >= 0 && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    queue.offer(new int[]{r-1, c});
                    fresh--;
                }
                if(r + 1 < grid.length && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    queue.offer(new int[]{r+1, c});
                    fresh--;
                }
                if(c - 1 >= 0 && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    queue.offer(new int[]{r, c-1});
                    fresh--;
                }
                if(c + 1 < grid[0].length && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    queue.offer(new int[]{r, c+1});
                    fresh--;
                }
            }
            res++;
        }
        return fresh == 0 ? res : -1;
    }
}
