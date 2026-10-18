class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        int key = image[sr][sc];
        int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        boolean[][] seen = new boolean[m][n];
        seen[sr][sc] = true;
        image[sr][sc] = newColor;
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for(int[] direction : directions){
                int newR = point[0] + direction[0];
                int newC = point[1] + direction[1];
                if(newR >= m || newC >= n || newR < 0 || newC < 0 || seen[newR][newC] == true){
                    continue;
                }
                if(image[newR][newC] == key){
                    image[newR][newC] = newColor;
                    seen[newR][newC] = true;
                    queue.add(new int[]{newR, newC});
                }
                if(image[newR][newC] != key){
                    seen[newR][newC] = true;
                }
            }
        }
        return image;
    }
}
