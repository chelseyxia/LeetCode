class Solution {
    public int longestStrChain(String[] words) {
        //not consecutive
        //dynamic programming
        int ans = 0;
        Set<String> set = new HashSet();
        for(String word : words){
            set.add(word);
        }
        
        Map<String, Integer> map = new HashMap();
        for(String word : words){
            ans = Math.max(ans, dfs(set, map, word));
        }
        return ans;
    }
    
    private int dfs(Set<String> set, Map<String, Integer> map, String word){
        //base case
        int maxLength = 1;
        if(map.containsKey(word)){
            return map.get(word);
        }
        
        StringBuilder sb = new StringBuilder(word);
        for(int i = 0; i < word.length(); i++){
            sb.deleteCharAt(i);
            String newS = sb.toString();
            if(set.contains(newS)){
                int current = 1 + dfs(set, map, newS);
                maxLength = Math.max(maxLength, current);
            }
            sb.insert(i, word.charAt(i));
        }
        
        map.put(word, maxLength);
        
        return maxLength;
    }
}
//abc -> abcd/adbc/abdc/dabc
