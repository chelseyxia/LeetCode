class Solution {
    public boolean validTicTacToe(String[] board) {
        int numX = 0;
        int numO = 0;
        for(String b : board){
            for(char ch : b.toCharArray()){
                if(ch == 'X'){
                    numX++;
                }
                if(ch == 'O'){
                    numO++;
                }
            }
        }
        return !((numX != numO && numO != numX - 1) || (numO != numX - 1 && win(board, 'X')) || (numX != numO && win(board, 'O')));
    }
    
    public boolean win(String[] board, char ch){
        for(int i = 0; i < 3; i++){
            if((ch == board[0].charAt(i) && ch == board[1].charAt(i) && ch == board[2].charAt(i)) || (ch == board[i].charAt(0) && ch == board[i].charAt(1) && ch == board[i].charAt(2))){   
                return true;
            }
        }
        return (ch == board[0].charAt(0) && ch == board[1].charAt(1) && ch == board[2].charAt(2)) || (ch == board[0].charAt(2) && ch == board[1].charAt(1) && ch == board[2].charAt(0));
    }
}
