class Solution {
    public int islandPerimeter(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int up, down, left, right;
        int result = 0;
        for(int r = 0; r < nr; ++r){
            for(int c = 0; c < nc; ++c){
                if(grid[r][c] == 1){
                    if(r == 0){
                        up = 0;
                    }
                    else{
                        up = grid[r-1][c];
                    }
                    if(c == 0){
                        left = 0;
                    }
                    else{
                        left = grid[r][c - 1];
                    }
                    if(r == nr - 1){
                        down = 0;
                    }
                    else{
                        down = grid[r + 1][c];   
                    }
                    if(c == nc - 1){
                        right = 0;
                    }
                    else{
                        right = grid[r][c + 1];
                    }
                    result += 4 - (up + down + left + right);
                }
            }
        }
        return result;
    }
}
