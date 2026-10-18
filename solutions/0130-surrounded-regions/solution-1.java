class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                boolean isEdge = i == 0 || j == 0 || i == n - 1 || j == m - 1;
                if(isEdge && board[i][j] == 'O'){
                    //board[i][j] = '#';
                    dfs(board, i, j);
                }
            }
        }
        //return board;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] == 'X' || board[i][j] == '#'){
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
