class Solution {
    public String licenseKeyFormatting(String s, int k) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isLowerCase(ch)){
                stack.add(Character.toUpperCase(ch));
            }
            if(ch == '-'){
                continue;
            }
            if(Character.isUpperCase(ch) || Character.isDigit(ch)){
                stack.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            int size = stack.size();
            if(size > k){
                for(int i = 0; i < k; i++){
                    char c = stack.pop();
                    sb.append(c);
                }
                sb.append('-');
            }

            if(size <= k){
                for(int i = 0; i < size; i++){
                    char c = stack.pop();
                    sb.append(c);
                }
            }
        }
        return sb.reverse().toString();
    }
}
