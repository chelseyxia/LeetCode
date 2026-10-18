class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(stack.isEmpty() && (ch == ')' || ch == ']' || ch == '}')){
                return false;
            }
            
            if(ch != ')' && ch != ']' && ch != '}'){
                stack.add(ch);
            }
            else{
                if(!stack.isEmpty()){
                    char t = stack.peek();
                    if(t == '(' && ch == ')'){
                        stack.pop();
                    }
                    else if(t == '[' && ch == ']'){
                        stack.pop();
                    }
                    else if(t == '{' && ch == '}'){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
