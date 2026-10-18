class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String lowerCase = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String[] words = lowerCase.split("\\s+");
        Set<String> bannedWord = new HashSet<String>();
        for(String word : banned){
            bannedWord.add(word);
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String word : words){
            if(!bannedWord.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
