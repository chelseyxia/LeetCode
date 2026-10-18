class Solution {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diag = 0; 
        int anti_diag = 0;
        int player = 1;
        for(int[] move : moves){
            int row = move[0];
            int col = move[1];
            rows[row] += player;
            cols[col] += player;
            if(row == col){
                diag += player;
            }
            if(row + col == n - 1){
                anti_diag += player;
            }
            if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(anti_diag) == n){
                return player == 1 ? "A" : "B";
            }
            player *= -1;
        }
        return moves.length == n * n ? "Draw" : "Pending";
    }
}

//00 11 22
//00 01 02
//10 11 12
//20 21 22
//02 11 20
