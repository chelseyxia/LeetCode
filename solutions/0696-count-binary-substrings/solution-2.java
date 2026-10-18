class Solution {
    public int countBinarySubstrings(String s) {
        int point = 0; 
        int n = s.length();
        int ans = 0;
        int last = 0;
        while(point < n){
            int count = 0;
            char ch = s.charAt(point);
            while(point < n && ch == s.charAt(point)){
                count++;
                point++;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }
}
