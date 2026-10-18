class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[mat.length][mat[0].length];
        int[][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
                else{
                    dist[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            for(int[] dir : dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr < 0 || nr >= mat.length || nc < 0 || nc >= mat[0].length){
                    continue;
                }
                if(dist[nr][nc] != -1){
                    continue;
                }
                dist[nr][nc] = dist[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
        return dist;
    }
}
