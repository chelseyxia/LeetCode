class Solution {
    public int calculate(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        char[] s_array = s.toCharArray();
        Stack<Integer> stack = new Stack();
        int n = s.length();
        int currNumber = 0;
        char operation = '+';
        for(int i = 0; i < n; i++){
            char c = s_array[i];
            if(Character.isDigit(c)){
                currNumber = (currNumber * 10) + (c - '0');
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1){
                if(operation == '-'){
                    stack.push(-currNumber);
                }
                else if(operation == '+'){
                    stack.push(currNumber);
                }
                else if(operation == '*'){
                    stack.push(stack.pop() * currNumber);
                }
                else if(operation == '/'){
                    stack.push(stack.pop() / currNumber);
                }
                operation = c;
                currNumber = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
