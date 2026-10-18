class Solution {
    public int calculate(String s) {
        s = "(" + s + ")";
        Stack<Integer> stack = new Stack();
        Stack<Character> sign = new Stack();
        HashMap<Character, Integer> map = new HashMap();
        map.put('+', 0);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put(')', -1);
        
        int cur = 1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                cur = cur * 10 + (ch - '0');
            }
            else{
                if(ch != '('){
                    stack.push(cur);
                    while(!sign.isEmpty() && sign.peek() != '(' && map.get(ch) <= map.get(sign.peek())){
                        char c = sign.pop();
                        int fir = stack.pop();
                        if(c == '+'){
                            stack.push(fir + stack.pop());
                        }
                        else if(c == '-'){
                            stack.push(stack.pop() - fir);
                        }
                        else if(c == '*'){
                            stack.push(stack.pop() * fir);
                        }
                        else{
                            stack.push(stack.pop() / fir);
                        }
                    }
                }
                if(ch == ')'){
                    sign.pop();
                    cur = stack.pop();
                }
                else{
                    cur = 0;
                    sign.push(ch);
                }
            }
        } 
        
        return cur;
    }
}
