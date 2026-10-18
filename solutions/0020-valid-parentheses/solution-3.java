class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n < 2){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != map.get(ch)){
                    return false;
                }
                stack.pop();
            }
            else{
                stack.push(ch);
            }
            
        }
        return stack.isEmpty();
    }
}
