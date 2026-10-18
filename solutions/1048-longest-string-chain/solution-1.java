class Solution {
    public int longestStrChain(String[] words) {
        Set<String> wordsPresent = new HashSet<String>();
        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        Collections.addAll(wordsPresent, words);
        int ans = 0;
        for(String word : words){
            ans = Math.max(ans, dfs(wordsPresent, memo, word));
        }
        return ans;
    }
    
    private int dfs(Set<String> words, Map<String, Integer> memo, String currentWord){
        if(memo.containsKey(currentWord)){
            return memo.get(currentWord);
        }
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);
        for(int i = 0; i < currentWord.length(); i++){
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if(words.contains(newWord)){
                int currentLength = 1 + dfs(words, memo, newWord);
                maxLength = Math.max(maxLength, currentLength);
            }
            sb.insert(i, currentWord.charAt(i));
        }
        memo.put(currentWord, maxLength);
        return maxLength;
    }
}
