class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int layers = 0;
        int rows = maze.length, cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                if((cur[0] == 0 || cur[0] == rows - 1 || cur[1] == 0 || cur[1] == cols - 1) && !(cur[0] == entrance[0] && cur[1] == entrance[1])){
                    return layers;
                }
                visited[cur[0]][cur[1]] = true;
                for(int[] dir : directions){
                    int newRow = cur[0] + dir[0];
                    int newCol = cur[1] + dir[1];
                    if(newRow < 0 || newRow >= maze.length || newCol < 0 || newCol >= maze[0].length){
                        continue;
                    }
                    if(maze[newRow][newCol] == '.' && !visited[newRow][newCol]){
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            layers++;
        }
        return -1;
    }
}
