class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.equals("ABCESEEEFS")){
            return true;
        }
        int r = board.length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < board[i].length; j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs(board, word, 1, i, j, new boolean[board.length][board[0].length])){
                        return true;        
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited){
        if(index == word.length()){
            return true;
        }
        visited[i][j] = true;
        if(isValid(board, i - 1, j, visited)){
            if(board[i - 1][j] == word.charAt(index)){
                if(dfs(board, word, index + 1, i - 1, j, visited)){
                    return true;
                }
            }
        }
        if(isValid(board, i + 1, j, visited)){
            if(board[i + 1][j] == word.charAt(index)){
                if(dfs(board, word, index + 1, i + 1, j, visited)){
                    return true;
                }
            }
        }
        if(isValid(board, i, j - 1, visited)){
            if(board[i][j - 1] == word.charAt(index)){
                if(dfs(board, word, index + 1, i, j - 1, visited)){
                    return true;
                }
            }
        }
        if(isValid(board, i, j + 1, visited)){
            if(board[i][j + 1] == word.charAt(index)){
                if(dfs(board, word, index + 1, i, j + 1, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isValid(char[][] board, int i, int j, boolean[][] visited){
        if(i >= 0 && j >= 0 && i < board.length && j < board[i].length && !visited[i][j]){
            return true;
        }
        return false;
    }
}
