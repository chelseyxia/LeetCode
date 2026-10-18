class Solution {
    public int numIslands(char[][] grid) {
        //BFS
        int ans = 0;
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                if(grid[i][j] == '1'){
                    ans++;
                    queue.offer(new Pair<>(i, j));
                    grid[i][j] = '*';
                    while(!queue.isEmpty()){
                        Pair<Integer, Integer> pair = queue.poll();
                        int r = pair.getKey();
                        int c = pair.getValue();
                        for(int[] dir : dirs){
                            int newR = r + dir[0];
                            int newC = c + dir[1];
                            if(newR >= rows || newC >= cols || newR < 0 || newC < 0 || grid[newR][newC] != '1'){
                                continue;
                            }
                            queue.offer(new Pair<>(newR, newC));
                            grid[newR][newC] = '*';
                        }
                    }
                }
            }
        }
        return ans;
    }
}
