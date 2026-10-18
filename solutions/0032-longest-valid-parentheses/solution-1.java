class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0){
            return 0;
        }
        int ans = 0;
        int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int temp = 0;
        stack.push(-1);
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else if(c == ')'){
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else if(!stack.isEmpty()){
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}
