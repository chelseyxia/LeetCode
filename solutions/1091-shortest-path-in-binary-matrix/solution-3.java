class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid == null || grid[0][0] == 1 || grid[n - 1][n - 1] == 1){
            return -1;
        }
        int shortestLength = 0;
        int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        Queue<List<int[]>> queue = new LinkedList<>(); 
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        queue.add(list);
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }
       // Arrays.fill(visited, false);
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            for(int j = 0; j < queue.size(); j++){
                List<int[]> tempList = queue.poll();
                int size = tempList.size();
                int a = tempList.get(size - 1)[0];
                int b = tempList.get(size - 1)[1];
                if((a == n - 1) && (b == n - 1)){
                    return size;
                }
                
                for(int i = 0; i < 8; i++){
                    int r = directions[i][0];
                    int c = directions[i][1];
                    int newA = a + r;
                    int newB = b + c;
                    if(newA < n && newB < n){
                        if(newA >= 0 && newB >= 0 && visited[newA][newB] == false && grid[newA][newB] == 0 && visited[newA][newB] == false){
                            List<int[]> temp = new ArrayList<>(tempList);
                            temp.add(new int[]{newA, newB});
                            queue.add(temp);
                            visited[newA][newB] = true;
                        }
                    }
                } 
            }
        }
        return -1;
    }
}
