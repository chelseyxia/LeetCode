class Solution {
    //part 1: initial variable
    int n = 3;
    int N = n * n;
    int[][] rows = new int[N][N + 1];
    int[][] cols = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];
    char[][] board;
    boolean sudokuSolved = false;
    
    //part 2: boolean couldPlace?
    public boolean couldPlace(int d, int row, int col){
        int idx = (row / n) * n + col / n;
        return rows[row][d] + cols[col][d] + boxes[idx][d] == 0;
    }
    
    //part 3: place number
    public void placeNumber(int d, int row, int col){
        int idx = (row / n) * n + col / n;
        
        rows[row][d]++;
        cols[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char)(d + '0');
    }
    
    //part 4: remove number
    public void removeNumber(int d, int row, int col){
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        cols[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }
    
    //part 5: place next number
    public void placeNextNumber(int row, int col){
        if((col == N - 1) && (row == N - 1)){
            sudokuSolved = true;
        }
        else{
            if(col == N - 1){
                backTracking(row + 1, 0);
            }
            else backTracking(row, col + 1);
        }
    }
    
    //part 6: part: backtrack
    public void backTracking(int row, int col){
        if(board[row][col] == '.'){
            for(int d = 1; d < 10; d++){
                if(couldPlace(d, row, col)){
                    placeNumber(d, row, col);
                    placeNextNumber(row, col);
                    if(!sudokuSolved){
                        removeNumber(d, row, col);
                    }
                }
            }
        }
        
        else{
            placeNextNumber(row, col);
        }
    }
    
    //part 7: solve sudoku
    public void solveSudoku(char[][] board) {
        this.board = board;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                char num = board[i][j];
                if(num != '.'){
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backTracking(0, 0);
    }
}
