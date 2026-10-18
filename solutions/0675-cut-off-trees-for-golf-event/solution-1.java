class Solution {
    public int cutOffTree(List<List<Integer>> forest) { 
        List<int[]> trees = new ArrayList<>();
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(0).size(); j++){
                if(forest.get(i).get(j) > 1){
                    trees.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }
        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 0, sr = 0, sc = 0;
        for(int[] tree : trees){
            int dist = bfs(forest, sr, sc, tree[1], tree[2]);
            if(dist < 0){
                return -1;
            }
            ans += dist;
            sr = tree[1];
            sc = tree[2];
        }
        
        return ans;
    }
    public int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //BFS
        Queue<int[]> path = new LinkedList<>();
        int m = forest.size();
        int n = forest.get(0).size();
        path.add(new int[]{sr, sc, 0});
        boolean[][] visited = new boolean[m][n];
        visited[sr][sc] = true;

        while(!path.isEmpty()){
            int[] currPath = path.poll();
            int row = currPath[0];
            int col = currPath[1];
            if(row == tr && col == tc){
                return currPath[2];
            }
            for(int[] direction : directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && !visited[newRow][newCol] && forest.get(newRow).get(newCol) > 0){
                    int[] tempPath = new int[]{newRow, newCol, currPath[2] + 1};
                    path.add(tempPath);
                    visited[newRow][newCol] = true;
                }
            }
        }
        return -1;
    }
}
