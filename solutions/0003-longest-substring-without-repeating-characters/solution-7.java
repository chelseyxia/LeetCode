class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int cnt = 0;
        int[] arr = new int[256];
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            start = arr[ch] != 0 ? Math.max(start, arr[ch]) : start;
            arr[ch] = i + 1;
            cnt = Math.max(cnt, i - start + 1);
        }
        return cnt;
    }
}
