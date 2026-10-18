class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        //make the string to lowercase
        String lowcase = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String[] words = lowcase.split("\\s+");
        Set<String> bannedWord = new HashSet();
        for(String word : banned){
            bannedWord.add(word);
        }
        Map<String, Integer> wordcount = new HashMap();
        for(String word : words){
            if(!bannedWord.contains(word)){
                wordcount.put(word, wordcount.getOrDefault(word, 0) + 1);
            }
        }
        return Collections.max(wordcount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
