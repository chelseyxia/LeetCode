class Solution {
    int newRow;
    int newCol;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        Queue<int[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;

        queue.offer(new int[]{start[0], start[1]});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == destination[0] && cur[1] == destination[1]){
                return true;
            }
            addNeighbor(dirs, cur[0], cur[1], maze, destination, queue, visited);
        }
        return false;
    }
    public void addNeighbor(int[][] dirs, int r, int c, int[][] maze, int[] des, Queue<int[]> queue, boolean[][] visited){
        for(int[] dir : dirs){
            newRow = r;
            newCol = c;
            while((newRow+dir[0]>= 0) && (newRow+dir[0]<maze.length) && (newCol+dir[1]>=0) && (newCol+dir[1]<maze[0].length) && maze[newRow+dir[0]][newCol+dir[1]]==0){
                newRow += dir[0];
                newCol += dir[1];
            }
            if(!visited[newRow][newCol]){
                visited[newRow][newCol] = true;
                queue.offer(new int[]{newRow, newCol});
            }
            // if(!visited[r][newCol]){
            //     visited[r][newCol] = true;
            //     queue.offer(new int[]{r, newCol});
            // }
        }
    }
}
