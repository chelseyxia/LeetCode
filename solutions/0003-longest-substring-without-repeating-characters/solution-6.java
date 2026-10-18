class Solution {
    public int lengthOfLongestSubstring(String s) {
        //abcabcbb
        int n = s.length();
        int cnt = 0;
        int start = 0;
        int[] arr = new int[256];
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            //abca
            start = arr[ch] != 0 ? Math.max(arr[ch], start) : start;
            arr[ch] = i + 1;
            cnt = Math.max(cnt, i - start + 1);
        }
        return cnt;
    }
}
