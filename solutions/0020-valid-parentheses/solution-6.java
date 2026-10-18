class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> que = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(que.isEmpty() || que.peek() != map.get(ch)){
                    return false;
                }
                que.pop();
            }
            else{
                que.push(ch);
            }
        }
        return que.isEmpty();
    }
}
