class Solution {
    public int maxDistance(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        boolean isLand = false;
        boolean isOcean = false;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int val = grid[i][j];
                if(val == 1){
                    isLand = true;
                    queue.offer(new int[]{i, j});
                }
                else{
                    isOcean = true;
                }
            }
        }
        if(!isLand || !isOcean){
            return -1;
        }
        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                 for(int[] dir : directions){
                    int newR = cur[0] + dir[0];
                    int newC = cur[1] + dir[1];
                    if(newR < 0 || newC < 0 || newR >= r || newC >= c || grid[newR][newC] != 0){
                        continue;
                    }
                    isOcean = true;
                    queue.offer(new int[]{newR, newC});
                    grid[newR][newC] = grid[cur[0]][cur[1]] + 1;
                 }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                res = Math.max(res, grid[i][j]);
            }
        }
        return res - 1;
    }
}
