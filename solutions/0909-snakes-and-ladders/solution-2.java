class Solution {
    int col;
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] isVisited = new boolean[n*n + 1];
        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int square = queue.poll();
                if(square == n * n){
                    return moves;
                }
                for(int j = 1; j <= 6; j++){
                    int next = square + j;
                    if(next > n * n){
                        break;
                    }
                    int[] nxtRowCol = nextRowCol(next, n);
                    int nxtRow = nxtRowCol[0], nxtCol = nxtRowCol[1];
                    if(board[nxtRow][nxtCol] != -1){
                        next = board[nxtRow][nxtCol];
                    }
                    if(!isVisited[next]){
                        isVisited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    public int[] nextRowCol(int s, int n){
        int zeroBased = s - 1;
        int rowFromBottom = zeroBased / n;
        int offset = zeroBased % n;
        int c;
        if(rowFromBottom % 2 == 0){
            c = offset;
        }
        else{
            c = n - 1 - offset;
        }
        return new int[]{n - 1 - rowFromBottom, c};
    }
}
