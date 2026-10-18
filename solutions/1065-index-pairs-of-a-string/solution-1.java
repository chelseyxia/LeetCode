class Solution {
    public int[][] indexPairs(String text, String[] words) {
        var root = buildTrie(words);
        var indexPairs = new ArrayList<int[]>();
        for(var i = 0; i < text.length(); i++){
            var node = root;
            for(var j = i; j < text.length(); j++){
                node = node.children.get(text.charAt(j));
                if(node == null){
                    break;
                }
                if(node.isWord){
                    indexPairs.add(new int[]{i, j});
                }
            }
        }
        return indexPairs.toArray(int[][] :: new);
    }
    private TrieNode buildTrie(String[] words){
        var root = new TrieNode('#');
        for(var word : words){
            insert(word, root);
        }
        return root;
    }
    private void insert(String word, TrieNode root){
        var node = root;
        for(var i = 0; i < word.length(); i++){
            var key = word.charAt(i);
            node = node.children.computeIfAbsent(key, k -> new TrieNode(key));
        }
        node.isWord = true;
    }
    private static class TrieNode {
        boolean isWord;
        char val;
        Map<Character, TrieNode> children = new HashMap<>();
        TrieNode(char val){
            this.val = val;
        }
    }
}
