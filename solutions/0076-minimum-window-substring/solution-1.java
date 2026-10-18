class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0){
            return "";
        }
        int slow = 0;
        int fast = 0;
        int ns = s.length();
        int nt = t.length();
        HashMap<Character, Integer> dicT = new HashMap();
        
        for(int i = 0; i < nt; i++){
            int count = dicT.getOrDefault(t.charAt(i), 0);
            dicT.put(t.charAt(i), count + 1);
        }
        int required = dicT.size();
        
        HashMap<Character, Integer> windowCounts = new HashMap();
        int[] ans = {-1, 0, 0};
        int formed = 0;
        while(fast < ns){
            char c = s.charAt(fast);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);
            if(dicT.containsKey(c) && windowCounts.get(c).intValue() == dicT.get(c).intValue()){
                formed++;
            }
            
            while(slow <= fast && formed == required){
                c = s.charAt(slow);
                if(ans[0] == -1 || fast - slow + 1 < ans[0]){
                    ans[0] = fast - slow + 1;
                    ans[1] = slow;
                    ans[2] = fast;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if(dicT.containsKey(c) && windowCounts.get(c).intValue() < dicT.get(c).intValue()){
                    formed--;
                }
                slow++;
            }
            fast++;
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
