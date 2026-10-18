//build a trienode map;
//backtracking

class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap();
    String word = null;
    public TrieNode(){
        
    }
}

class Solution {
    char[][] _board = null;
    ArrayList<String> ans = new ArrayList();
    public List<String> findWords(char[][] board, String[] words) {
        //adjacent cell: hor and verti
        //construct trie
        TrieNode root = new TrieNode();
        
        for(String word : words){
            TrieNode node = root;
            
            for(Character ch : word.toCharArray()){
                if(node.children.containsKey(ch)){
                    node = node.children.get(ch);
                }
                else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(ch, newNode);
                    node = newNode;
                }
            }
            
            node.word = word;
        }
        
        this._board = board;
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(root.children.containsKey(board[row][col])){
                    backTracking(row, col, root);
                }
            }
        }
        return ans;
    }
    
    private void backTracking(int r, int c, TrieNode parent){
        Character letter = this._board[r][c];
        TrieNode currNode = parent.children.get(letter);
        
        if(currNode.word != null){
            ans.add(currNode.word);
            currNode.word = null;
        }
        
        this._board[r][c] = '#';
        
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        
        for(int i = 0; i < 4; i++){
            int newRow = r + rowOffset[i];
            int newCol = c + colOffset[i];
            if(newRow < 0 || newCol < 0 || newRow >= _board.length || newCol >= _board[0].length){
                continue;
            }
            
            if(currNode.children.containsKey(_board[newRow][newCol])){
                backTracking(newRow, newCol, currNode);
            }
        }
        
        _board[r][c] = letter;
        
        if(currNode.children.isEmpty()){
            parent.children.remove(letter);
        }
    }
}
