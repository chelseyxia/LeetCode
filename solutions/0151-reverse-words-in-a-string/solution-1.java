class Solution {
    public String reverseWords(String s) {
             //use split and stack
        String[] res = s.trim().split("\\s+");
        Stack<String> stack = new Stack<String>(); 
        for(int i = 0; i < res.length; i++){
            stack.push(res[i]);
        }
        String[] m = new String[res.length];
        for(int i = 0; i < m.length - 1; i++){
            m[i] = stack.pop() + " ";
        }
        m[m.length - 1] = stack.pop();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < m.length; i++){
            sb.append(m[i]);
        }
        String ans = sb.toString();
        return ans;
    }
}
