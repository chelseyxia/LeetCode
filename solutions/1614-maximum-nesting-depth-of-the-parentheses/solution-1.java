class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack();
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                ans = Math.max(ans, stack.size());
                stack.pop();
            }
            
        }
        
        return ans;
    }
}
