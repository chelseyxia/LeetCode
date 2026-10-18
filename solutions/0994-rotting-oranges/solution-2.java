class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int elementOne = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i, j));
                }
                if(grid[i][j] == 1){
                    elementOne++;
                }
            }
        }
        if(elementOne == 0){
            return 0;
        }
        int count = 0;
        int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair<Integer, Integer> pair = queue.poll();
                int a = pair.getKey();
                int b = pair.getValue();
                for(int j = 0; j < 4; j++){
                    int newA = a + directions[j][0];
                    int newB = b + directions[j][1];
                    if(newA >= n || newB >= m || newA < 0 || newB < 0){
                        continue;
                    }
                    if(grid[newA][newB] == 1){
                        grid[newA][newB] = 2;
                        queue.offer(new Pair(newA, newB));
                        elementOne--;
                    }
                }
            }

        }
        return elementOne == 0 ? count - 1 : -1;
    }
}
