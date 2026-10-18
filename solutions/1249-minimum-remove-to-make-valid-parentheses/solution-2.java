class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.add(i);
            }
            if(c == ')'){
                if(stack.isEmpty()){
                    indexToRemove.add(i);
                }
                else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            indexToRemove.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(!indexToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
