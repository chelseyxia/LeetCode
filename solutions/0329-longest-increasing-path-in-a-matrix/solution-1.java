class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] outdegrees = new int[rows][cols];
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                for(int[] dir : dirs){
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if(newR < rows && newR >= 0 && newC < cols && newC >= 0 && matrix[newR][newC] > matrix[r][c]){
                        ++outdegrees[r][c];
                    }
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){    
                if(outdegrees[r][c] == 0){
                    queue.offer(new int[]{r, c});
                }
            }
        }
        int steps = 0;
        
        while(!queue.isEmpty()){
            ++steps;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                for(int[] dir : dirs){
                    int newR = row + dir[0];
                    int newC = col + dir[1];
                    if(newR < rows && newR >= 0 && newC < cols && newC >= 0 && matrix[newR][newC] < matrix[row][col]){
                        --outdegrees[newR][newC];
                        if(outdegrees[newR][newC] == 0){
                            queue.offer(new int[]{newR, newC});
                        }
                    }
                }
            }
        }
        return steps;
    }
    
    /*public boolean outside(int r, int c, int rows, int cols){
        if(r < rows && r >= 0 && c < cols && c >= 0){
            return true;
        }
        return false;
    }*/
}
