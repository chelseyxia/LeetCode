class Solution {
    public int calculate(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack();
        int sign = 1;
        int n = s.length();
        int currNumber = 0;
        
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNumber = (currNumber * 10) +(int)(c - '0');
            }
            else if(c == '+'){
                result += sign * currNumber;
                sign = 1;
                currNumber = 0;
            }
            else if(c == '-'){
                result += sign * currNumber;
                sign = -1;
                currNumber = 0;
            }
            else if(c == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }
            else if(c == ')'){
                result += sign * currNumber;
                result *= stack.pop();
                result += stack.pop();
                currNumber = 0;
            }
        }
        return result + (sign * currNumber);
    }
}
