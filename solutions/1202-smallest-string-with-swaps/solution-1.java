class unionFind{
    int[] root;
    int[] rank;
    public unionFind(int size){
        root = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x){
        if(root[x] == x){
            return x;
        }
        return root[x] = find(root[x]);
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] >= rank[rootY]){
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
            }
            else{
                root[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
        }
    }
    
}

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        unionFind unionfind = new unionFind(s.length());
        for(List<Integer> pair : pairs){
            int x = pair.get(0);
            int y = pair.get(1);
            unionfind.union(x, y);
        }
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            int root = unionfind.find(i);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(i);
        }
        char[] smallestString = new char[s.length()];
        for(List<Integer> indices : map.values()){
            List<Character> characters = new ArrayList<>();
            for(int index : indices){
                characters.add(s.charAt(index));
            }
            Collections.sort(characters);
            for(int index = 0; index < indices.size(); index++){
                smallestString[indices.get(index)] = characters.get(index);
            }
        }
        
        return new String(smallestString);
    }
}
