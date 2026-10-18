class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        //use stack and for loop list all the possibilities
        Stack<Integer> stack = new Stack<Integer>();
        for(String op : ops){
            if(op.equals("+")){
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            }
            else if(op.equals("C")){
                stack.pop();
            }
            else if(op.equals("D")){
                int newtop = stack.peek() * 2;
                stack.push(newtop);
            }
            else{
                stack.push(Integer.valueOf(op));
            }
        }
        for(int score : stack){
            sum += score;
        }
        return sum;
    }
}
