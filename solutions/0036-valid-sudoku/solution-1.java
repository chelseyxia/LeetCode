class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] columns = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        
        for(int i = 0; i < N; i++){
            rows[i] = new HashSet<Character>();
            columns[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }
        
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                char val = board[r][c];
                if(val == '.'){
                    continue;
                }
                if(rows[r].contains(val)){
                    return false;
                }
                rows[r].add(val);
                if(columns[c].contains(val)){
                    return false;
                }
                columns[c].add(val);
                int index = (r / 3) * 3 + c / 3;
                if(boxes[index].contains(val)){
                    return false;
                }
                boxes[index].add(val);
            }
        }
        return true;
    }
}
