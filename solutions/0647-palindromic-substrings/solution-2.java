class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            cnt += countPalin(s, i, i);//odd
            cnt += countPalin(s, i, i + 1);//even
        }
        return cnt;
    }
    private int countPalin(String s, int lo, int hi){
        int ans = 0;
        while(lo >= 0 && hi < s.length()){
            if(s.charAt(lo) != s.charAt(hi)){
                break;
            }
            lo--;
            hi++;
            ans++;
        }
        return ans;
    }
}
