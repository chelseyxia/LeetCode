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
                else if(rooms[i][j] == -1){
                    gates[i][j] = -2;
                }
                else{
                    gates[i][j] = -1;
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
                if(gates[nr][nc] != -1){
                    continue;
                }
                gates[nr][nc] = gates[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
        for(int i = 0; i < gates.length; i++){
            for(int j = 0; j < gates[0].length; j++){
                if(gates[i][j] == -1){
                    gates[i][j] = 2147483647;
                }
                if(gates[i][j] == -2){
                    gates[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < gates.length; i++) {
            rooms[i] = gates[i].clone(); // Deep copies the current row
        }
    }
}
