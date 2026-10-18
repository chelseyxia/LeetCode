class Solution {
    public String decodeString(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            
            if(ch >= 'a' && ch <= 'z'){
                ans.append(ch);
                continue;
            }
            if(ch >= '0' && ch <= '9'){
                count *= 10;
                count += ch - '0';
            }
            if(ch == '['){
                int current = getClosingBracket(s, i);
                String temp = decodeString(s.substring(i + 1, current));
                for(int j = 0; j < count; j++){
                    ans.append(temp);
                }
                i = current - 1;
            }
            if(ch == ']'){
                count = 0;
            }
        }
        
        return ans.toString();
    }
    private int getClosingBracket(String s, int index){
        int openBracket = 1;
        for(int i = index + 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '['){
                openBracket++;
            }
            if(ch == ']'){
                openBracket--;
            }
            if(openBracket == 0){
                return i;
            }
        }
        return -1;
    }
}
