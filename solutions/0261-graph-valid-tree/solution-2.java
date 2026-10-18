class unionFind{
    int[] root;
    public unionFind(int size){
        root = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
        }
    }
    public int find(int x){
        if(x == root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }
    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return false;
        }
        root[rootY] = rootX;
        return true;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int rows = edges.length;        
        unionFind unionfind = new unionFind(n);
        int temp = Math.abs(n - rows);
        if(temp != 1){
            return false;
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(!unionfind.union(a, b)){
                return false;
            }
        }
        return true;
    }
}
