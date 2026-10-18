class Solution {
    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    public int swimInWater(int[][] grid) {
        int route = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int valueA = grid[a[0]][a[1]];
            int valueB = grid[b[0]][b[1]];
            return Integer.compare(valueA, valueB);
        });
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        minHeap.offer(new int[]{0, 0});
        visited[0][0] = true;
        int rows = grid.length;
        int cols = grid[0].length;
        while(!minHeap.isEmpty()){
            int[] indexes = minHeap.poll();
            int r = indexes[0];
            int c = indexes[1];
            route = Math.max(route, grid[r][c]);
            if(r == rows - 1 && c == cols - 1){
                return route;
            }
            addNeighbor(directions, visited, minHeap, r, c, grid, route);
        }
        return route;
    }
    public void addNeighbor(int[][] dirs, boolean[][] visited, PriorityQueue<int[]> minHeap, int r, int c, int[][] grid, int route){
        for(int[] dir : dirs){
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            if(newRow >= grid.length || newCol >= grid[0].length || newRow < 0 || newCol < 0 || visited[newRow][newCol]){
                continue;
            }
            minHeap.offer(new int[]{newRow, newCol});
            visited[newRow][newCol] = true;
        }
    }
}
