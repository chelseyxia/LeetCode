class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        List<String> kwords = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            kwords.add(entry.getKey());
        }
        Collections.sort(kwords, new Comparator<String>(){
            public int compare(String word1, String word2){
                return map.get(word1) == map.get(word2) ? word1.compareTo(word2) : map.get(word2) - map.get(word1);
            }
        });
        return kwords.subList(0, k);
    }
}
