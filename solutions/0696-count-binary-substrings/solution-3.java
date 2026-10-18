class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0;
        int cur = 1;
        int res = 0;
        
        char[] ch = s.toCharArray();
        for(int i = 1; i < s.length(); i++){
            if(ch[i] == ch[i - 1]){
                cur++;
            }
            else{
                res += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
            
        }
        res += Math.min(prev, cur);
        return res;
    }
}
