class Trie {
    
    static class Node{
        Map<Character, Node> children = new HashMap<>();
        int prefixCount = 0;
        int wordCount = 0;
    }
    private Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node cur = root;
        for(char ch : word.toCharArray()){
            if(!cur.children.containsKey(ch)){
                cur.children.put(ch, new Node());
            }
            cur = cur.children.get(ch);
            cur.prefixCount++;
        }
        cur.wordCount++;
    }
    public int countWordsEqualTo(String word) {
        Node cur = root;
        for(char ch : word.toCharArray()){
            cur = cur.children.get(ch);
            if(cur == null){
                return 0;
            }
        }
        return cur.wordCount;
    }
    public int countWordsStartingWith(String prefix) {
        Node cur = root;
        for(char ch : prefix.toCharArray()){
            cur = cur.children.get(ch);
            if(cur == null){
                return 0;
            }
        }
        return cur.prefixCount;
    }
    public void erase(String word) {
        Node cur = root;
        for(char ch : word.toCharArray()){
            Node child = cur.children.get(ch);
            if(cur == null){
                return;
            }
            if(child.prefixCount == 1){
                cur.children.remove(ch);
                return;
            }
            else{
                child.prefixCount--;
                cur = child;
            }
        }
        cur.wordCount--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
