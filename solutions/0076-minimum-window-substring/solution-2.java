class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n){
            return "";
        }
        //slide window: need 2 pointers
        int i = 0, j = 0;
        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();
        for(int k = 0; k < n; k++){
            char ch = t.charAt(k);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }
        int have = 0, need = mapT.size();
        int[] res = {-1, -1};
        int reslen = Integer.MAX_VALUE;
        for(j = 0; j < m; j++){
            char ch = s.charAt(j);
            mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);
            int temp = mapS.get(ch);
            if(mapT.containsKey(ch) && temp == mapT.get(ch)){
                have += 1;
            }
            while(have == need && i <= j){
                if(j - i + 1 < reslen){
                    res[0] = i;
                    res[1] = j;
                    reslen = j - i + 1;
                } 
                //mapS.remove(s.charAt(i));
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) - 1);
                if(mapT.containsKey(s.charAt(i)) && mapS.get(s.charAt(i)) < mapT.get(s.charAt(i))){
                    have--;
                }
                i++;
            }
        }
        return reslen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
