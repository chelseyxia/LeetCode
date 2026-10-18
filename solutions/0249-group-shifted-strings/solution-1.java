class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        //hashmap record the word and it's length
        HashMap<String, List<String>> map = new HashMap();
        Set<Integer> set = new HashSet();
        int n = strings.length;
        
        for(String word : strings){
            String hash = getHash(word);
            map.putIfAbsent(hash, new ArrayList());
            map.get(hash).add(word);
        }
        List<List<String>> result = new ArrayList();
        
        for(String hash : map.keySet()){
            result.add(map.get(hash));
        }
        return result;
    }
    
    private String getHash(String word){
        char[] chs = word.toCharArray();
        StringBuilder hash = new StringBuilder();
        for(int i = 1; i < word.length(); i++){
            hash.append((char)((chs[i] - chs[i - 1] + 26) % 26 + 'a'));
        }
        return hash.toString();
    }
}
