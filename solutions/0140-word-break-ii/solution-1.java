class Solution {
    protected Set<String> wordSet;
    protected HashMap<String, List<List<String>>> memo;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet();
        memo = new HashMap();
        for(String word : wordDict){
            wordSet.add(word);
        }
        
        wordbreak_topdown(s);
        
        List<String> ret = new ArrayList();
        for(List<String> words : memo.get(s)){
            StringBuffer sentence = new StringBuffer();
            for(String word : words){
                sentence.insert(0, word);
                sentence.insert(0, " ");
            }
            ret.add(sentence.toString().strip());
        }
        
        return ret;
    }
    
    public List<List<String>> wordbreak_topdown(String s){
        if(s.equals("")){
            List<List<String>> solution = new ArrayList();
            solution.add(new ArrayList<String>());
            return solution;
        }
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        else{
            List<List<String>> solution = new ArrayList();
            memo.put(s, solution);
        }
        for(int endIndex = 1; endIndex <= s.length(); endIndex++){
            String word = s.substring(0, endIndex);
            if(wordSet.contains(word)){
                List<List<String>> subsentences = wordbreak_topdown(s.substring(endIndex));
                for(List<String> subsentence : subsentences){
                    List<String>newSentence = new ArrayList<>(subsentence);
                    newSentence.add(word);
                    memo.get(s).add(newSentence);
                }
            }
        }
        
        return memo.get(s);
    }
}
