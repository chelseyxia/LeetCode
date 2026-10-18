class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] res = new int[n * m];
        int k = 0;
        
        boolean bXFlag = true;
        
        for(int i = 0; i < n + m; i++){
            int pn = bXFlag ? n : m;
            int pm = bXFlag ? m : n;
            
            int x = (i < pn) ? i : pn - 1;
            int y = i - x;
            
            while(x >= 0 && y < pm){
                res[k++] = bXFlag ? mat[x][y] : mat[y][x];
                x--;
                y++;
            }
            bXFlag = !bXFlag;
        }
        return res;
    }
}
