class unionFind{
    int[] root;
    int[] setSize;
    public unionFind(int size){
        root = new int[size];
        setSize = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
            setSize[i] = 1;
        }
    }
    public int find(int x){
        if(x == root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            root[rootY] = rootX;
        }
    }
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        unionFind unionfind = new unionFind(n);
        int cnt = 0;
        HashSet<Integer> set = new HashSet();
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            unionfind.union(x, y);
            set.add(unionfind.find(x));
        }
        
        for(int i = 0; i < n; i++){
            if(unionfind.root[i] == i){
                cnt++;
            }
        }
        return cnt;
    }
}
