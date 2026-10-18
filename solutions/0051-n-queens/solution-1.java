class Solution {
    private int size;
    private List<List<String>> solutions = new ArrayList();
    
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char emptyBoard[][] = new char[size][size];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                emptyBoard[i][j] = '.';
            }
        }
        backTracking(0, new HashSet<>(), new HashSet(), new HashSet(), emptyBoard);
        return solutions;
    }
    
    private List<String> createBoard(char[][] state){
        List<String> board = new ArrayList();
        
        for(int row = 0; row < size; row++){
            String curr_row = new String(state[row]);
            board.add(curr_row);
        }
        
        return board;
    }
    
    private void backTracking(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, char[][] state){
        //base case: N queens have been placed
        if(row == size){
            solutions.add(createBoard(state));
            return;
        }
        
        for(int col = 0; col < size; col++){
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            //if not placeable
            if(cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)){
                continue;
            }
            
            //add the queen to the board
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            state[row][col] = 'Q';
            
            backTracking(row + 1, diagonals, antiDiagonals, cols, state);
            
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col] = '.';
        }
    }
}
