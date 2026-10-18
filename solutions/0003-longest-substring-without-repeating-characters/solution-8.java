class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int n = s.length();
        if(n == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
