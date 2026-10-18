class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, n);
        return res;
    }
    public void backtrack(List<List<String>> res, List<String> board, int row, int n){
        if(row == n){
            res.add(new ArrayList<>(board));
            return;
        }
        for(int col = 0; col < n; col++){
            if(!isSafe(board, row, col, n)){
                continue;
            }
            board.add(build(col, n));
            backtrack(res, board, row + 1, n);
            board.remove(board.size() - 1);
        }

    }
    public boolean isSafe(List<String> board, int row, int col, int n){
        for(int r = 0; r < row; r++){
            if(board.get(r).charAt(col) == 'Q'){
                return false;
            }
        }
        for(int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
        }
        for(int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
        }
        return true;
    }
    public String build(int col, int n){
        char[] row = new char[n];
        Arrays.fill(row, '.');
        row[col] = 'Q';
        return new String(row);
    }
}
