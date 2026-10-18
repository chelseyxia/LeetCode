class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    HashMap<Pair<Integer, Integer>, Boolean> snakeMap;
    Deque<Pair<Integer, Integer>> snake;
    int[][] food;
    int foodIndex;
    int width;
    int height;
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.width = width;
        this.height = height;
        this.snakeMap = new HashMap<Pair<Integer, Integer>, Boolean>();
        this.snakeMap.put(new Pair<Integer, Integer>(0, 0), true);
        this.snake = new LinkedList<Pair<Integer, Integer>>();
        this.snake.offerLast(new Pair<Integer, Integer>(0, 0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Pair<Integer, Integer> snakeCell = this.snake.peekFirst();
        int newHeadRow = snakeCell.getKey();
        int newHeadColumn = snakeCell.getValue();
        
        switch (direction){
            case "U":
                newHeadRow--;
                break;
            case "D":
                newHeadRow++;
                break;
            case "L":
                newHeadColumn--;
                break;
            case "R":
                newHeadColumn++;
                break;
        }
        Pair<Integer, Integer> newHead = new Pair<Integer, Integer>(newHeadRow, newHeadColumn);
        Pair<Integer, Integer> currentTail = this.snake.peekLast();
        boolean crossBoundary1 = newHeadRow < 0 || newHeadRow >= this.height;
        boolean crossBoundary2 = newHeadColumn < 0 || newHeadColumn >= this.width;
        boolean biteItself = this.snakeMap.containsKey(newHead) && !(newHead.getKey() == currentTail.getKey() && newHead.getValue() == currentTail.getValue());
        if(crossBoundary1 || crossBoundary2 || biteItself){
            return -1;
        }
        if((this.foodIndex < this.food.length) && (this.food[this.foodIndex][0] == newHeadRow) && (this.food[this.foodIndex][1] == newHeadColumn)){
            this.foodIndex++;
        }
        else{
            this.snake.pollLast();
            this.snakeMap.remove(currentTail);
        }
        this.snake.addFirst(newHead);
        this.snakeMap.put(newHead, true);
        return this.snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
