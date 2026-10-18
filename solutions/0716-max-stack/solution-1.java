class MaxStack {
    Deque<Integer> xStack;
    Deque<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        xStack = new LinkedList<Integer>();
        maxStack = new LinkedList<Integer>();
        maxStack.push(Integer.MIN_VALUE);
    }
    
    public void push(int x) {
        xStack.push(x);
        maxStack.push(Math.max(maxStack.peek(), x));
    }
    
    public int pop() {
        maxStack.pop();
        return xStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = peekMax();
        Deque<Integer> buffer = new LinkedList<Integer>();
        while(top() != max){
            buffer.push(pop());
        }
        pop();
        while(!buffer.isEmpty()){
            push(buffer.pop());
        }
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
