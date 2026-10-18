class Solution {
    public String minWindow(String s, String t) {
        int left = 0, formed = 0, start = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int required = need.size();
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
            }
            if(need.containsKey(c) && window.get(c).equals(need.get(c))){
                formed++;
            }
            while(formed == required){
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if(need.containsKey(leftChar)){
                    window.put(leftChar, window.get(leftChar) - 1);
                    if(window.get(leftChar) < need.get(leftChar)){
                        formed--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

}
