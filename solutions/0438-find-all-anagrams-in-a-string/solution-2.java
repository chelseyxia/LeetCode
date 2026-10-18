class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        List<Integer> ans = new ArrayList<Integer>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        for(int right = 0; right < s.length(); right++){
            char cur = s.charAt(right);
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            int windowLen = right - left + 1;
            if(windowLen > p.length()){
                char leftChar = s.charAt(left);
                window.put(leftChar, window.getOrDefault(leftChar,0) - 1);
                if(window.get(leftChar) == 0){
                    window.remove(leftChar);
                }
                left++;
            }
            if(right - left + 1 == p.length()){
                if(window.equals(need)){
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}
