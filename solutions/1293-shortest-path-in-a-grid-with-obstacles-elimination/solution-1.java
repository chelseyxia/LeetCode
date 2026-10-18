class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPath(int[][] grid, int k) {
        int steps = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        if(k >= rows + cols - 3){
            return rows + cols - 2;
        }
        boolean[][][] visited = new boolean[rows][cols][k + 1];
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;
        
        while(!queue.isEmpty()){
            steps++;
            int size = queue.size();
            
            while(size -- > 0){
                int[] curr = queue.poll();
                int currR = curr[0];
                int currL = curr[1];
                int currK = curr[2];
        
                for(int[] dir : dirs){
                    int nextR = currR + dir[0];
                    int nextL = currL + dir[1];
                    if(nextR >= 0 && nextR < rows && nextL >= 0 && nextL < cols){
                        if(grid[nextR][nextL] == 0 && !visited[nextR][nextL][currK]){
                            if((nextR == rows - 1) && nextL == cols - 1){
                                return steps;
                            }
                            else{
                                visited[nextR][nextL][currK] = true;
                                queue.offer(new int[]{nextR, nextL, currK});
                            }
                        }
                        else if(grid[nextR][nextL] == 1 && currK > 0 && !visited[nextR][nextL][currK]){
                            visited[nextR][nextL][currK - 1] = true;
                            queue.add(new int[]{nextR, nextL, currK - 1});
                            
                        }
                    } 
                }
            }
        }
        
        
        return -1;
    }
}
