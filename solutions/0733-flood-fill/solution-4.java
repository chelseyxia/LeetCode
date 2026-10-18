class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, color, visited, image[sr][sc]);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color, boolean[][] visited, int target){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length){
            return;
        }
        if(visited[sr][sc] || image[sr][sc] != target){
            return;
        }
        visited[sr][sc] = true;
        image[sr][sc] = color;
        dfs(image, sr - 1, sc, color, visited, target);
        dfs(image, sr + 1, sc, color, visited, target);
        dfs(image, sr, sc - 1, color, visited, target);
        dfs(image, sr, sc + 1, color, visited, target);
    }
}
