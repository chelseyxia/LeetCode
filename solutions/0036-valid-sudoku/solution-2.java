class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for(int i = 0; i < N; i++){
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxes[i] = new HashSet();
        }
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char ch = board[row][col];
                if(ch == '.'){
                    continue;
                }
                if(rows[row].contains(ch)){
                    return false;
                }
                rows[row].add(ch);
                if(cols[col].contains(ch)){
                    return false;
                }
                cols[col].add(ch);
                int index = (row / 3) * 3 + col / 3;
                if(boxes[index].contains(ch)){
                    return false;
                }
                boxes[index].add(ch);
            }
        }
        return true;
    }
}
