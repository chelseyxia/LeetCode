class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        char[] s_arr = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(char ch : s_arr){
            if(map.containsKey(ch)){
                stack.push(map.get(ch));
            }
            else if(!stack.isEmpty() && stack.peek() == ch){
                stack.pop();
            }
            else{
                return false;
            }
        }
        if(stack.size() == 0){
            return true;
        }
        return false;
    }
}
