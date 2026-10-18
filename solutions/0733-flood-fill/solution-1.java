class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if(currColor == newColor){
            return image;
        }
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> que = new LinkedList<int[]>();
        que.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while(!que.isEmpty()){
            int[] cell = que.poll();
            int x = cell[0];
            int y = cell[1];
            for(int i = 0; i < 4; i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if(mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor){
                    que.offer(new int[] {mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}
