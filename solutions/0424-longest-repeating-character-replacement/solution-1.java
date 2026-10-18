class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        if(n < 2){
            return n;
        }
        int left = 0;
        int right = 0;
        int[] map = new int[26];
        int historyMaxCount = 0;
        for(right = 0; right < n; right++){
            int index = arr[right] - 'A';
            map[index]++;
            historyMaxCount = Math.max(historyMaxCount, map[index]);
            if(right - left + 1 > historyMaxCount + k){
                map[arr[left] - 'A']--;
                left++;
            }
        }
        return n - left;
    }
}
