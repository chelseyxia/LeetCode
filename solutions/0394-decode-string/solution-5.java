class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ']'){
                stack.add(s.charAt(i));
            }
            else if(s.charAt(i) == ']'){
                //StringBuilder sbTemp = new StringBuilder();
                List<Character> list = new ArrayList<>();
                while(stack.peek() != '['){
                    list.add(stack.pop());
                }
                //String newS = sbTemp.reverse().toString();
                stack.pop();
                int base = 1;
                int k = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                while(k != 0){
                    for(int j = list.size() - 1; j >= 0; j--){
                        stack.add(list.get(j));
                    }                    
                    k--;
                }
            }
        }
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
}
