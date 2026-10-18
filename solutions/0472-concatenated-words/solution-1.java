class Trie{
    Trie[] children;
    boolean isEnd;
    
    public Trie(){
        children = new Trie[26];
        isEnd = false;
    }
}

class Solution {
    Trie trie = new Trie();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        //some words can compose other word
        // or we can think whether a word int the array is composed by other words in the array
        //so, I think we can use data structure: 
        //it's a problem about dictionary tree: trie and dfs
        List<String> res = new ArrayList();
        int n = words.length;
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for(String word : words){
            if(word.length() == 0){
                continue;
            } 
            if(dfs(word, 0)){
                res.add(word);
            }
            else{
                insert(word);
            }
        }
        return res;
    }
    
    private boolean dfs(String word, int start){
        if(word.length() == start){
            return true;
        }
        
        Trie node = trie;
        for(int i = start; i < word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            node = node.children[index];
            if(node == null){
                return false;
            }
            if(node.isEnd){
                if(dfs(word, i + 1)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private void insert(String word){
        Trie node = trie;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        
        node.isEnd = true;
    }
}
