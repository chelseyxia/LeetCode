class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length() == 0 || s.isEmpty()){
            return 0;
        }
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            if(c == ')' && stack.peek() == '('){
                stack.pop();
            }
            else{
                stack.push(c);
            }            
        }
        return stack.size();
    }
}
