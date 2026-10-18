class SnakeGame {
    int r, c, w, h, i, f[][];
    Queue<int[]> snake = new ArrayDeque<>();
    public SnakeGame(int width, int height, int[][] food) {
        this.w = width;
        this.h = height;
        this.f = food;
        snake.add(new int[2]);
    }
    
    public int move(String direction) {
        switch(direction.charAt(0)){
                case 'D' -> r++;
                case 'U' -> r--;
                case 'R' -> c++;
                case 'L' -> c--;
        }
        
        if(r < 0 || c < 0 || r == h || c == w){
            return -1;
        }
        
        if(i < f.length && r == f[i][0] && c == f[i][1]){
            i++;
        }
        
        else{
            snake.poll();
            for(int[] s : snake){
                if(s[0] == r && s[1] == c){
                    return -1;
                }
            }
        }
        
        snake.add(new int[]{r, c});
        return snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
