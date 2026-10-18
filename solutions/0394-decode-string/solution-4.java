class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '['){
                int closeBracket = getCloseBracket(i, s);
                String stemp = decodeString(s.substring(i + 1, closeBracket));
                for(int j = 0; j < count; j++){
                    ans.append(stemp);
                }
                i = closeBracket - 1;
            }
            if(ch == ']'){
                count = 0;
            }
            if(ch >= '0' && ch <= '9'){
                count *= 10;
                count += ch - '0';
            }
            if(ch >= 'a' && ch <= 'z'){
                ans.append(ch);
                continue;
            }
        }
        
        return ans.toString();
    }
    private int getCloseBracket(int start, String s){
        int openBracket = 1;
        for(int i = start + 1; i < s.length(); i++){
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
