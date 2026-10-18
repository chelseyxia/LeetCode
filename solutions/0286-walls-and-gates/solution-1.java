class Solution {
    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;
        Deque<int[]> q = new ArrayDeque<int[]>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rooms[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        int INF = Integer.MAX_VALUE;
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while(!q.isEmpty()){
            int[] room = q.poll();
            for(int[] dir : dirs){
                int x = room[0] + dir[0];
                int y = room[1] + dir[1];
                if(x < 0 || y < 0 || x >= n || y >= m || rooms[x][y] != INF){
                    continue;
                }
                rooms[x][y] = rooms[room[0]][room[1]] + 1;
                q.add(new int[]{x, y});
            }
        }
    }
}
