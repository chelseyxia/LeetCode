class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(sb.toString());
                sb.setLength(0);
            }
            else if(ch == ')'){
                sb.reverse();
                sb.insert(0, stack.pop());
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
