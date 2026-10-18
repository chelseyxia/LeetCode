class Solution {
    public int minimumEffortPath(int[][] heights) {
        int effort = 0;
        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        minHeap.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
        while(!minHeap.isEmpty()){
            int[] curIndexes = minHeap.poll();
            visited[curIndexes[0]][curIndexes[1]] = true;
            if(curIndexes[0] == heights.length - 1 && curIndexes[1] == heights[0].length - 1){
                return curIndexes[2];
            }
            addNeighbor(dirs, heights, curIndexes[0], curIndexes[1], visited, minHeap, curIndexes[2]);
        }
        return effort;
    }
    public void addNeighbor(int[][] dirs, int[][] heights, int r, int c, boolean[][] visited, PriorityQueue<int[]> minHeap, int eff){
        for(int[] dir : dirs){
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            if(newRow < 0 || newCol < 0 || newRow >= heights.length || newCol >= heights[0].length || visited[newRow][newCol] == true){
                continue;
            }
            int edgDiff = Math.abs(heights[r][c] - heights[newRow][newCol]);
            int newEff = Math.max(eff, edgDiff);
            minHeap.offer(new int[]{newRow, newCol, newEff});
        }
    }
}
