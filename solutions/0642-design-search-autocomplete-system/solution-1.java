class AutocompleteSystem {
    class Trie{
        Map<Character, Trie> children;
        Map<String, Integer> counts;
        
        public Trie(){
            this.children = new HashMap();
            this.counts = new HashMap();
        }
    }
    
    class Pair{
        int c; 
        String s;
        public Pair(String s, int c){
            this.c = c;
            this.s = s;
        }
    }
    
    Trie root;
    StringBuilder prefix;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        prefix = new StringBuilder();
        for(int i = 0; i < sentences.length; i++){
            add(sentences[i], times[i]);
        }
    }
    
    private void add(String s, int cnt){
        Trie curr = root;
        for(char c : s.toCharArray()){
            Trie next = curr.children.get(c);
            if(next == null){
                next = new Trie();
                curr.children.put(c, next);
            }
            curr = next;
            curr.counts.put(s, curr.counts.getOrDefault(s, 0) + cnt);
        }
    }
    
    public List<String> input(char c) {
        if(c== '#'){
            add(prefix.toString(), 1);
            prefix = new StringBuilder();
            return new ArrayList();
        }
        prefix.append(c);
        Trie curr = root;
        for(char cc : prefix.toString().toCharArray()){
            Trie next = curr.children.get(cc);
            if(next == null){
                return new ArrayList();
            }
            curr = next;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c);
        
        for(Map.Entry<String, Integer> e : curr.counts.entrySet()){
            pq.offer(new Pair(e.getKey(), e.getValue()));
        }
        
        List<String> res = new ArrayList();
        for(int i = 0; i < 3 && !pq.isEmpty(); i++){
            res.add(pq.poll().s);
        }
        
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
