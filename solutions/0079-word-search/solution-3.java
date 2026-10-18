class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(backTracking(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backTracking(char[][] board, int r, int c, String word, int index){
        int[] d = {0, 1, 0, -1};
        int[] l = {1, 0, -1, 0};
        int rows = board.length;
        int cols = board[0].length;
        if(index >= word.length()){
            return true;
        }
        if(r >= rows || c >= cols || r < 0 || c < 0 || board[r][c] != word.charAt(index)){
            return false;
        }
        boolean ret = false;
        board[r][c] = '#';
        for(int i = 0; i < 4; i++){
            int t1 = r + d[i];
            int t2 = c + l[i];
            ret = backTracking(board, t1, t2, word, index + 1);  
            if(ret){
                break;
            }
        }
        board[r][c] = word.charAt(index);
        return ret;
    }
}
