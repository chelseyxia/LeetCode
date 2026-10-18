class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int ans = 0;
        for(char ch : t.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }
        for(char ch : map.keySet()){
            ans += map.get(ch);
        }
        return ans;
    }
}
