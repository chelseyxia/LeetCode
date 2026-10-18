class Solution {
    public void wallsAndGates(int[][] rooms) {
        //-1: leave it as is
        //0: leave it as is
        //
        int[][] gates = new int[rooms.length][rooms[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            for(int[] dir : dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr <0 || nr >= rooms.length || nc < 0 || nc >= rooms[0].length){
                    continue;
                }
                if(rooms[nr][nc] != Integer.MAX_VALUE){
                    continue;
                }
                rooms[nr][nc] = rooms[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
