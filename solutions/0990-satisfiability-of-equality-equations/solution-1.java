class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for(int i = 0; i < 26; i++){
            parent[i] = i;
        }
        
        for(String equation : equations){
            if(equation.charAt(1) == '='){
                int idx1 = equation.charAt(0) - 'a';
                int idx2 = equation.charAt(3) - 'a';
                union(parent, idx1, idx2);
            }
        }
        
        for(String equation : equations){
            if(equation.charAt(1) == '!'){
                int idx1 = equation.charAt(0) - 'a';
                int idx2 = equation.charAt(3) - 'a';
                if(find(parent, idx1) == find(parent, idx2)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private void union(int[] parent, int idx1, int idx2){
        parent[find(parent, idx1)] = find(parent, idx2);
    }
    
    private int find(int[] parent, int idx){
        while(parent[idx] != idx){
            parent[idx] = parent[parent[idx]];
            idx = parent[idx];
        }
        return idx;
    }
}
