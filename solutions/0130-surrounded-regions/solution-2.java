class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            if(board[i][board[0].length - 1] == 'O'){
                dfs(board, i, board[0].length - 1);
            }
        }
        for(int j = 0; j < board[0].length; j++){
            if(board[0][j] == 'O'){
                dfs(board, 0, j);
            }
            if(board[board.length - 1][j] == 'O'){
                dfs(board, board.length - 1, j);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int r, int c){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length){
            return;
        }
        if(board[r][c] == 'X' || board[r][c] == 'T'){
            return;
        }
        if(board[r][c] == 'O'){
            board[r][c] = 'T';
        }
        dfs(board, r-1, c);
        dfs(board, r+1, c);
        dfs(board, r, c-1);
        dfs(board, r, c+1);

    }
}
