class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap();
        char[] s_array = s.toCharArray();
        int slow = 0;
        int fast = 0;
        int max_len = 1;
        int n = s.length();
        while(fast < n){
            map.put(s.charAt(fast), fast++);
            if(map.size() == k + 1){
                int lowestIndex = Collections.min(map.values());
                map.remove(s.charAt(lowestIndex));
                slow = lowestIndex + 1;
            }
            
            max_len = Math.max(max_len, fast - slow);
        }
        return max_len;
    }
}
