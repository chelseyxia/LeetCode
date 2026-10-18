class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack();
        char[] s_array = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char c = s_array[i];
            if(c == ']'){
                List<Character> decodeString = new ArrayList();
                while(stack.peek() != '['){
                    decodeString.add(stack.pop());
                }
                stack.pop();
                int base = 1;
                int k = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                    
                }
                while(k != 0){
                    for(int j = decodeString.size() - 1; j >= 0; j--){
                        stack.push(decodeString.get(j));
                    }
                    k--;
                }
            }
            else{
                stack.push(c);
            }
        }
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
}
