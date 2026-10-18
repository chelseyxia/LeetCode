class Solution {
    public int firstUniqChar(String s) {
        int res = s.length();
        for(char ch = 'a'; ch <= 'z'; ch++){
            int i = s.indexOf(ch);
            if(i != -1 && i == s.lastIndexOf(ch)){
                res = Math.min(res, i);
            }
        }
        if(res == s.length()){
            return -1;
        }
        return res;
    }
}
