class MagicDictionary {
    class Node{
        Node[] next = new Node[26];
        boolean isEnd;
    }
    Node root = new Node();
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        for(String word : dictionary){
            Node cur = root;
            for(char c : word.toCharArray()){
                if(cur.next[c - 'a'] == null){
                    cur.next[c - 'a'] = new Node();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isEnd = true;
        }
    }
    
    public boolean search(String searchWord) {
        return search_word(searchWord, 0, false, root);
    }
    public boolean search_word(String w, int index, boolean used, Node cur){
        if(cur == null){
            return false;
        }
        if(index == w.length()){
            return cur.isEnd && used;
        }
        int j = w.charAt(index) - 'a';
        for(int i = 0; i < 26; i++){
            if((!used || i == j) && search_word(w, index + 1, used || i != j, cur.next[i])){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
