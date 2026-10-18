class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, left = 0, maxFreq = 0, windowLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(cur));
            windowLen = i - left + 1;
            if(windowLen - maxFreq > k){
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                left++;
            }
            res = Math.max(res, i - left + 1);

        }
        return res;
    }
}
