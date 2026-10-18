class Solution {
    public int firstUniqChar(String s) {
        int result = s.length();
        for(char c = 'a'; c <= 'z'; c++){
            int i = s.indexOf(c);
            if(i != -1 && i == s.lastIndexOf(c)){
                result = Math.min(result, i);
            }
        }
        if(result == s.length()){
            return -1;
        }
        return result;
    }
}
